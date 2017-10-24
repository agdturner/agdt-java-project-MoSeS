/**
 * A component of a library for 
 * <a href="http://www.ncess.ac.uk/moses">MoSeS</a>
 * Copyright (C) 2006 
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy Turner</a>,
 * <a href="http://www.leeds.ac.uk//">University of Leeds</a>.
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

import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataHandler;

/**
 * Abstract class for handling data output.
 */
public abstract class AbstractOutputDataHandler extends Census_AbstractDataHandler {

    /**
     * File for writing output to.
     */
    protected File _OutputFile;
    /**
     * FileOutputStream for _OutputFile.
     */
    protected FileOutputStream _FileOutputStream;
    /**
     * ToyModelDataHandler.
     */
    protected ToyModelDataHandler _ToyModelDataHandler;
    /**
     * Census_CASDataHandler.
     */
    protected Census_CASDataHandler _CASDataHandler;
    /**
     * CASDataHandler_GA_IPS.
     */
    protected CASDataHandler_GA_IPS _CASDataHandler_1;

    /** Required method
     * @return  */
    @Override
    public Census_AbstractDataRecord getDataRecord(long RecordID) {
        return null;
    }

    /**
     * Writes out header.
     * @throws java.io.IOException
     */
    public abstract void writeHeader() throws IOException;

    public abstract void writeObserved(
            String _CASDataDirectory,
            String _OutputFileName,
            long _StartRecordID,
            long _EndRecordID,
            String _AreaLevel,
            Census_ISARDataHandler tISARDataHandler)
            throws IOException;

    public abstract void writeEstimated_HSARHP(
            File _InputFile,
            File _OutputFile,
            String _Aggregation)
            throws IOException;

    // /**
    // * Writes _Counts for _ZoneCode
    // */
    // protected abstract void write(
    // Counts _Counts,
    // String _ZoneCode )
    // throws IOException;
    public abstract class Counts {
    }
}
