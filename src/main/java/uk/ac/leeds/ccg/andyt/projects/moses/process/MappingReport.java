/**
 * A component of a library for
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS">MoSeS</a>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA.
 */
package uk.ac.leeds.ccg.andyt.projects.moses.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Vector;
import uk.ac.leeds.ccg.andyt.projects.moses.io.WebContentHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * A class for generating maps comparing CAS data with IndividualCensus outputs
 * in the form of geographical maps.
 */
public abstract class MappingReport extends WebContentHandler {

	public MappingReport() {
	}

	protected static Object[] loadData(File _SARExpectedFile,
			File _CASObservedFile) throws IOException {
		Object[] result = new Object[4];
		BufferedReader _SARExpectedBufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(_SARExpectedFile)));
		StreamTokenizer _SARExpectedStreamTokenizer = new StreamTokenizer(
				_SARExpectedBufferedReader);
		Generic_StaticIO.setStreamTokenizerSyntax3(_SARExpectedStreamTokenizer);
		int _SARExpectedTokenType = _SARExpectedStreamTokenizer.nextToken();
		BufferedReader _CASObservedBufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(_CASObservedFile)));
		StreamTokenizer _CASObservedStreamTokenizer = new StreamTokenizer(
				_CASObservedBufferedReader);
		Generic_StaticIO.setStreamTokenizerSyntax3(_CASObservedStreamTokenizer);
		int _CASObservedTokenType = _CASObservedStreamTokenizer.nextToken();
		// Read Headers
		String a_SARExpectedLine = _SARExpectedStreamTokenizer.sval;
		String[] _SARExpectedVariables = a_SARExpectedLine.split(",");
		String a_CASObservedLine = _CASObservedStreamTokenizer.sval;
		String[] _CASObservedVariables = a_CASObservedLine.split(",");
		int _NumberNumericalVariables = 0;
		// Check variables names the same
		if (_SARExpectedVariables.length != _CASObservedVariables.length) {
			System.out
					.println("t_SARExpectedVariables.length != _CASObservedVariables.length");
		} else {
			_NumberNumericalVariables = _SARExpectedVariables.length - 1;
			// for ( int i = 0; i < _SARExpectedVariables.length; i ++ ) {
			// if ( ! _CASObservedVariables[i].equalsIgnoreCase(
			// _SARExpectedVariables[i] ) ) {
			// System.out.print( _CASObservedVariables[i] + " != " +
			// _SARExpectedVariables[i] );
			// }
			// }
		}
		result[0] = _SARExpectedVariables; // Variable Names
		// Read Data
		double[] a_SARExpectedRow = new double[_NumberNumericalVariables];
		Vector _SARExpectedRows = new Vector();
		double[] a_CASObservedRow = new double[_NumberNumericalVariables];
		Vector _CASObservedRows = new Vector();
		_SARExpectedTokenType = _SARExpectedStreamTokenizer.nextToken();
		_CASObservedTokenType = _CASObservedStreamTokenizer.nextToken();
		Vector _ZoneCodes = new Vector();
		int _NumberOfAreas = 0;
		while (_SARExpectedTokenType != StreamTokenizer.TT_EOF
				&& _CASObservedTokenType != StreamTokenizer.TT_EOF) {
			if (_SARExpectedTokenType != _CASObservedTokenType) {
				System.out
						.println("t_SARExpectedTokenType != _CASObservedTokenType");
			} else {
				switch (_SARExpectedTokenType) {
				case StreamTokenizer.TT_WORD:
					_NumberOfAreas++;
					a_SARExpectedRow = new double[_NumberNumericalVariables];
					a_SARExpectedLine = _SARExpectedStreamTokenizer.sval;
					_SARExpectedVariables = a_SARExpectedLine.split(",");
					a_CASObservedLine = _CASObservedStreamTokenizer.sval;
					a_CASObservedRow = new double[_NumberNumericalVariables];
					_CASObservedVariables = a_CASObservedLine.split(",");
					if (_SARExpectedVariables.length != _CASObservedVariables.length) {
						System.out
								.println("t_SARExpectedVariables.length != _CASObservedVariables.length");
					}
					if (_NumberNumericalVariables != _SARExpectedVariables.length - 1) {
						System.out
								.println("t_NumberNumericalVariables != _SARExpectedVariables.length - 1");
					}
					// if ( _CASObservedVariables[ 0 ].startsWith(
					// _SARExpectedVariables[ 0 ] ) ) {
					_ZoneCodes.add(_CASObservedVariables[0]);
					for (int i = 0; i < _NumberNumericalVariables; i++) {
						a_SARExpectedRow[i] = Double.valueOf(
								_SARExpectedVariables[i + 1]).doubleValue();
						a_CASObservedRow[i] = Double.valueOf(
								_CASObservedVariables[i + 1]).doubleValue();
						// if ( i == 1 && ( a_SARExpectedRow[ i ] !=
						// a_CASObservedRow[ i ] ) ) {
						// System.out.println(
						// "Warning ! constraint that allHouseholds observed ( "
						// + a_CASObservedRow[ i ] +
						// ") = allHouseholds expected ( " + a_SARExpectedRow[ i
						// ] + " ) not met for " + _CASObservedVariables[ 0 ] );
						// }
					}
					_SARExpectedRows.add(a_SARExpectedRow);
					_CASObservedRows.add(a_CASObservedRow);
					// } else {
					// System.out.println( _CASObservedVariables[ 0 ] + " != " +
					// _SARExpectedVariables[ 0 ] );
					// }
				}
			}
			_SARExpectedTokenType = _SARExpectedStreamTokenizer.nextToken();
			_CASObservedTokenType = _CASObservedStreamTokenizer.nextToken();
		}
		if (_SARExpectedRows.size() != _CASObservedRows.size()) {
			System.out
					.println("t_SARExpectedRows.size() != _CASObservedRows.size()");
		}
		if (_NumberOfAreas != _SARExpectedRows.size()) {
			System.out.println("t_NumberOfAreas != _SARExpectedRows.size()");
		}
		// Format (Flip) data
		double[][] _SARExpectedData = new double[_NumberNumericalVariables][_NumberOfAreas];
		double[][] _CASObservedData = new double[_NumberNumericalVariables][_NumberOfAreas];
		for (int j = 0; j < _NumberOfAreas; j++) {
			a_SARExpectedRow = (double[]) _SARExpectedRows.elementAt(j);
			a_CASObservedRow = (double[]) _CASObservedRows.elementAt(j);
			for (int i = 0; i < _NumberNumericalVariables; i++) {
				_SARExpectedData[i][j] = a_SARExpectedRow[i];
				_CASObservedData[i][j] = a_CASObservedRow[i];
			}
		}
		result[1] = _SARExpectedData;
		result[2] = _CASObservedData;
		result[3] = _ZoneCodes;
		return result;
	}

}
