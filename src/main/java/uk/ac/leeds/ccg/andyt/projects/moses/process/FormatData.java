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

import java.io.File;
import java.io.IOException;
import uk.ac.leeds.ccg.andyt.agdtcensus.cas.CASDataHandler;
import uk.ac.leeds.ccg.andyt.agdtcensus.sar.HSARDataHandler;
import uk.ac.leeds.ccg.andyt.agdtcensus.sar.ISARDataHandler;

/**
 * A class for formatting all original census data into more readable forms.
 */
public class FormatData {

	/** Creates a new instance of FormatData */
	public FormatData() {
	}

	/**
	 * @param args
	 *            the command line arguments
     * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {

        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
		// File directory = new File("/home/andyt/projects/MoSeS/Workspace/" );

		// ISARDataHandler_AGE0Indexed.main(args);
        
        // HSAR
        HSARDataHandler aHSARDataHandler = new HSARDataHandler();
        aHSARDataHandler.init(directory);
        File sourceHSAR = new File(
                "C:/Work/data/Census/2001/SAR/household/5278TAB/UKDA-5278-tab/tab/lichhd-051019.tab");
        File formattedHSAR = new File(directory,"HSARDataRecords.dat");
        aHSARDataHandler.formatSource(
                sourceHSAR,
                formattedHSAR);

        // ISAR
        ISARDataHandler aISARDataHandler_AGE0HRPOrdered = new ISARDataHandler();
        aISARDataHandler_AGE0HRPOrdered.init(directory);
        File sourceISAR = new File(
                "C:/work/data/census/2001/SAR/01uklicind-20050401.dat");
        File formattedISAR = new File(
                directory,
                "ISARDataRecords.dat");
        aISARDataHandler_AGE0HRPOrdered.formatSource(
                sourceISAR,
                formattedISAR);

        // CAS
        CASDataHandler aCASDataHandler = new CASDataHandler(directory);
        aCASDataHandler.formatSourceData();

        // CAS

    }


}
