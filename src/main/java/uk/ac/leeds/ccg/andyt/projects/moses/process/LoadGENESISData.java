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
import uk.ac.leeds.ccg.andyt.agdtcensus.cas.CASAreaEastingNorthingDataHandler;
import uk.ac.leeds.ccg.andyt.agdtcensus.cas.CASAreaEastingNorthingDataRecord;
import uk.ac.leeds.ccg.andyt.agdtcensus.cas.CASDataHandler;
import uk.ac.leeds.ccg.andyt.agdtcensus.sar.HSARDataHandler;
import uk.ac.leeds.ccg.andyt.agdtcensus.sar.ISARDataHandler;
import uk.ac.leeds.ccg.andyt.agdtcensus.cas.SWSDataHandler;
import uk.ac.leeds.ccg.andyt.agdtcensus.cas.SWSDataRecord;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * A class for loading formatted data and generating serialised handlers.
 */
public class LoadGENESISData {

    public LoadGENESISData() {
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        LoadGENESISData aLoadData = new LoadGENESISData();
        aLoadData.run();
    }

    public void run() {
        //loadTest();
        loadFormattedData();
    }

//    public void loadTest() {
//        File directory = new File("C:/Work/Projects/GENESIS/Workspace/");
//        // File directory = new File("/home/andyt/projects/MoSeS/Workspace/" );
//        File file;
//        // HSAR
//        file = new File(
//                directory,
//                HSARDataHandler.class.getCanonicalName() + ".thisFile");
//        HSARDataHandler aHSARDataHandler = new HSARDataHandler(
//                file);
//        // ISAR
//        file = new File(
//                directory,
//                ISARDataHandler.class.getCanonicalName() + ".thisFile");
//        ISARDataHandler aISARDataHandler = new ISARDataHandler(
//                file);
//        // CAS
//        CASDataHandler aCASDataHandler = new CASDataHandler(directory, "OA");
//    }
    public void loadFormattedData() {
        File directory = new File("C:/Work/Projects/GENESIS/Workspace/");
        // File directory = new File("/home/andyt/projects/MoSeS/Workspace/" );
        File file;
        // SWS
        SWSDataHandler a_SWSDataHandler;
        file = new File(
                directory,
                "SWSDataRecords.dat");
        a_SWSDataHandler = new SWSDataHandler(file);
        file = new File(
                directory,
                SWSDataHandler.class.getCanonicalName() + ".thisFile");
        Generic_StaticIO.writeObject(
                a_SWSDataHandler,
                file);
        a_SWSDataHandler = new SWSDataHandler(
                file);
        System.out.println("a_SWSDataHandler.getNDataRecords() " + a_SWSDataHandler.getNDataRecords());
        SWSDataRecord a_SWSDataRecord = (SWSDataRecord) a_SWSDataHandler.getDataRecord(0L);
        System.out.println("a_SWSDataRecord " + a_SWSDataRecord);

        // CASAreaEastingNorthingDataRecords.dat
        CASAreaEastingNorthingDataHandler a_CASAreaEastingNorthingDataHandler;
        file = new File(
                directory,
                "CASAreaEastingNorthingDataRecords.dat");
        a_CASAreaEastingNorthingDataHandler = new CASAreaEastingNorthingDataHandler(file);
        file = new File(
                directory,
                CASAreaEastingNorthingDataHandler.class.getCanonicalName() + ".thisFile");
        Generic_StaticIO.writeObject(
                a_CASAreaEastingNorthingDataHandler,
                file);
        a_CASAreaEastingNorthingDataHandler = new CASAreaEastingNorthingDataHandler(
                file);
        System.out.println("a_CASAreaEastingNorthingDataHandler.getNDataRecords() " + a_CASAreaEastingNorthingDataHandler.getNDataRecords());
        CASAreaEastingNorthingDataRecord a_CASAreaEastingNorthingDataRecord = (CASAreaEastingNorthingDataRecord) a_CASAreaEastingNorthingDataHandler.getDataRecord(0L);
        System.out.println("a_CASAreaEastingNorthingDataRecord " + a_CASAreaEastingNorthingDataRecord);
    }
}
