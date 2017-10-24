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
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_HSARDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;

/**
 * A class for loading formatted data and generating serialised handlers.
 */
public class LoadData {

    public LoadData() {
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        LoadData aLoadData = new LoadData();
        aLoadData.run();
    }

    public void run() {
        //loadTest();
        loadFormattedData();
    }

    public void loadTest() {
        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
        // File directory = new File("/home/andyt/projects/MoSeS/Workspace/" );
        File file;
        // HSAR
        file = new File(
                directory,
                Census_HSARDataHandler.class.getCanonicalName() + ".thisFile");
        Census_HSARDataHandler aHSARDataHandler = new Census_HSARDataHandler(
                file);
        // ISAR
        file = new File(
                directory,
                Census_ISARDataHandler.class.getCanonicalName() + ".thisFile");
        Census_ISARDataHandler aISARDataHandler = new Census_ISARDataHandler(
                file);
        // CAS
        Census_CASDataHandler aCASDataHandler = new Census_CASDataHandler(directory, "OA");
    }

    public void loadFormattedData() {
        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
        // File directory = new File("/home/andyt/projects/MoSeS/Workspace/" );
        File file;
        // HSAR
        Census_HSARDataHandler aHSARDataHandler;
        file = new File(
                directory,
                "HSARDataRecords.dat");
        aHSARDataHandler = new Census_HSARDataHandler(file);
        file = new File(
                directory,
                Census_HSARDataHandler.class.getCanonicalName() + ".thisFile");
        aHSARDataHandler = new Census_HSARDataHandler(
                file);
//        // ISAR
//        Census_ISARDataHandler aISARDataHandler;
//        // Load source formatted data
//        file = new File(
//                directory,
//                "ISARDataRecords.dat");
//        aISARDataHandler = new Census_ISARDataHandler(file);
//        // Write out thisfile
//        file = new File(
//                directory,
//                aISARDataHandler.getClass().getCanonicalName() + ".thisFile");
//        aISARDataHandler = new Census_ISARDataHandler(
//                file);
        // CAS
        Census_CASDataHandler aCASDataHandler = new Census_CASDataHandler(
                directory,
                "OA");
    }
}
