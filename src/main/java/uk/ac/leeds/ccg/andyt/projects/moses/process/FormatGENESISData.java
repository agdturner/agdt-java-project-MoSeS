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
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASAreaEastingNorthingDataHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.io.SWSDataHandler;

/**
 * A class for formatting all original census data into more readable forms.
 */
public class FormatGENESISData {

	/** Creates a new instance of FormatData */
	public FormatGENESISData() {
	}

	/**
	 * @param args
	 *            the command line arguments
     * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {

        File directory = new File("C:/Work/Projects/GENESIS/Workspace/");
		
        // SWS
        SWSDataHandler a_SWSDataHandler = new SWSDataHandler();
        //SWSDataHandler a_SWSDataHandler = new SWSDataHandler(directory);
        //File sourceSWS = new File(
        //        "C:/Work/data/Census/2001/SWS_STS/w3/W301_OUT.csv" );
        //File formattedSWS = new File(directory,"SWSDataRecords.dat");
        a_SWSDataHandler.formatSourceData(
                new File(
                "C:/Work/data/Census/2001/SWS_STS/w3/"),
                20);

        // Area Easting Northing
        CASAreaEastingNorthingDataHandler a_CASAreaEastingNorthingDataHandler = new CASAreaEastingNorthingDataHandler();
        a_CASAreaEastingNorthingDataHandler.formatSourceData(
                new File(
                "C:/Work/data/Census/2001/"),
                20);

    }


}
