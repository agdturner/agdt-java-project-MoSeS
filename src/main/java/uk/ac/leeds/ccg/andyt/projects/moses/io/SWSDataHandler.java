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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.util.Random;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * Class for handling Special Workplace Statistics (SWS) DataRecords.
 */
public class SWSDataHandler extends AbstractCASDataHandler {

    public SWSDataHandler() {
        File directory = new File("C:/Work/Projects/GENESIS/Workspace/");
        this.init(directory);
        try {
            this._File = new File(directory, "SWSDataRecords.dat");
            if (!this._File.exists()) {
                this._File.createNewFile();
            }
            this._RecordLength = new SWSDataRecord().getSizeInBytes();
            // log("this.recordLength " + this.recordLength);
            this._RandomAccessFile = new RandomAccessFile(this._File, "r");
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    public SWSDataHandler(File a_File) {
        this.init(a_File.getParentFile());
        if (a_File.getName().endsWith("thisFile")){
            SWSDataHandler a_SWSDataHandler = (SWSDataHandler) Generic_StaticIO.readObject(a_File);
            this._File = a_SWSDataHandler._File;
            load(_File);
        } else {
            load(a_File);
        }
        this._RecordLength = new SWSDataRecord().getSizeInBytes();
        log("SWSDataRecords loaded successfully");
    }
    
    public SWSDataHandler(File a_File, boolean flag) {
        this.init(a_File);
        File tSWSfile = new File(a_File,SWSDataHandler.class.getName() + ".thisFile");
        SWSDataHandler a_SWSDataHandler = (SWSDataHandler) Generic_StaticIO.readObject(tSWSfile);
        this._File = a_SWSDataHandler._File;
        load(_File);
        this._RecordLength = new SWSDataRecord().getSizeInBytes();
        log("SWSDataRecords loaded successfully");
    }

    /**
     * Loads <code>CAS001DataRecords</code> and prints out n randomly
     * @param directory to load source data from
     * @param n the number of loaded data records to print out.
     */
    public void formatSourceData(
            File directory,
            int n) {
        try {
            _RandomAccessFile = new RandomAccessFile(this._File, "rw");
            // Load from source
            File infile;
            long RecordID = 0L;
            // Load
            infile = new File(
                    directory,
                    //"W301_OUT.csv");
                    "00DA_W301_OUT.csv");
            RecordID = format(infile, RecordID);
            log(infile.toString() + " formatted successfully " + RecordID + " records"); // 165665
            _RandomAccessFile.close();
            load(_File);
            print(20, new Random());
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Uses a <code>BufferedReader<code> and a <code>StreamTokenizer</code> to
     * read lines from the sourceFile <code>File</code>. The lines are converted
     * to <code>CAS001DataRecords</code> and written to
     * <code>this.tRandomAccessFile</code>.
     *
     * @param sourceFile
     *            The source CAS001DataRecords file to be formatted and written
     *            to <code>this.tRandomAccessFile</code>.
     * @param RecordID
     *            The <code>RecordID</code> to assign to the first
     *            <code>CAS001DataRecord</code>.
     * @return The <code>RecordID</code> assigned to the last
     *         <code>CAS001DataRecords</code>.
     */
    protected long format(
            File sourceFile,
            long RecordID) {
        try {
            BufferedReader aBufferedReader =
                    new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(sourceFile)));
            StreamTokenizer aStreamTokenizer =
                    new StreamTokenizer(aBufferedReader);
            Generic_StaticIO.setStreamTokenizerSyntax1(aStreamTokenizer);
            String line;
            SWSDataRecord a_SWSDataRecord = new SWSDataRecord();
            // Skip the first line
            int tokenType = aStreamTokenizer.nextToken();
            while (tokenType != StreamTokenizer.TT_EOL) {
                tokenType = aStreamTokenizer.nextToken();
            }
            tokenType = aStreamTokenizer.nextToken();
            while (tokenType != StreamTokenizer.TT_EOF) {
                switch (tokenType) {
                    case StreamTokenizer.TT_EOL:
                        if (RecordID % 10000 == 0 && RecordID > 0) {
                            log(a_SWSDataRecord.toString());
                        }
                        // Write out
                        if (new String(a_SWSDataRecord.Zone_Code).startsWith("00DA") &&
                                new String(a_SWSDataRecord._Destination_Zone_Code).startsWith("00DA")) {
                            a_SWSDataRecord.write(_RandomAccessFile);
                            RecordID++;
                        }
                        break;
                    case StreamTokenizer.TT_WORD:
                        line = aStreamTokenizer.sval;
                        a_SWSDataRecord = new SWSDataRecord(RecordID, line);
                        break;
                }
                tokenType = aStreamTokenizer.nextToken();
            }
            log("Number of Records loaded = " + RecordID);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return RecordID;
    }

    public AbstractCASDataRecord getDataRecord(long RecordID) {
        return getSWSDataRecord(RecordID);
    }

    public SWSDataRecord getSWSDataRecord(long RecordID) {
        SWSDataRecord result = null;
        try {
            this._RandomAccessFile.seek(_RecordLength * RecordID);
            result = new SWSDataRecord(this._RandomAccessFile);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return result;
    }

    
    public void setFile(File a_File) {
        this._File = a_File;
        load(_File);
    }
}