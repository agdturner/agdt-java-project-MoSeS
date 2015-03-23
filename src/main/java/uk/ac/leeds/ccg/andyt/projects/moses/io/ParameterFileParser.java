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
package uk.ac.leeds.ccg.andyt.projects.moses.io;

import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Class for parsing Parameter Files.
 * @author geoagdt
 */
public class ParameterFileParser {

	public static Object[] parse(File aFile) {
		Object[] tInput_Parameters = new Object[12];
		BufferedReader aBufferedReader = null;
		try {
			aBufferedReader = 
                    new BufferedReader(
                    new InputStreamReader(
					new FileInputStream(aFile)));
		} catch (FileNotFoundException _FileNotFoundException) {
			System.err.println(_FileNotFoundException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.FileNotFoundException);
		}
		StreamTokenizer aStreamTokenizer = new StreamTokenizer(aBufferedReader);
		Generic_StaticIO.setStreamTokenizerSyntax5(aStreamTokenizer);
		String _String;
		int index = 0;
		try {
			int tokenType = aStreamTokenizer.nextToken();
			while (tokenType != StreamTokenizer.TT_EOF) {
				switch (tokenType) {
				case StreamTokenizer.TT_EOL:
					index++;
					break;
				case StreamTokenizer.TT_WORD:
					_String = aStreamTokenizer.sval;
					switch (index) {
					case 0:
						tInput_Parameters[index] = new File(_String);
						break;
					case 1:
						tInput_Parameters[index] = _String;
						break;
					case 2:
						tInput_Parameters[index] = _String;
						break;
					case 3:
						tInput_Parameters[index] = new Integer(_String);
						break;
					case 4:
						tInput_Parameters[index] = new Integer(_String);
						break;
					case 5:
						tInput_Parameters[index] = new Integer(_String);
						break;
					case 6:
						tInput_Parameters[index] = new Integer(_String);
						break;
					case 7:
						tInput_Parameters[index] = new Integer(_String);
						break;
					case 8:
						tInput_Parameters[index] = new Integer(_String);
						break;
					case 9:
						tInput_Parameters[index] = new Long(_String);
						break;
					case 10:
						tInput_Parameters[index] = _String;
						break;
					case 11:
						tInput_Parameters[index] = _String;
						break;
					}
					// System.out.println(_String);
					break;
				}
				tokenType = aStreamTokenizer.nextToken();
			}
            aBufferedReader.close();
		} catch (IOException aIOException) {
			System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
		}
		return tInput_Parameters;
	}
}
