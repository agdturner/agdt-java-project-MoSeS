/**
 * A component of a library for
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS">MoSeS</a>.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package uk.ac.leeds.ccg.andyt.projects.moses.io;

import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_IO;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * Class for parsing Parameter Files.
 *
 * @author geoagdt
 */
public class ParameterFileParser {

    public static Object[] parse(File f) {
        Object[] result = new Object[12];
        BufferedReader br;
        br = Generic_IO.getBufferedReader(f);
        StreamTokenizer st = new StreamTokenizer(br);
        Generic_IO.setStreamTokenizerSyntax5(st);
        String s;
        int index = 0;
        try {
            int tokenType = st.nextToken();
            while (tokenType != StreamTokenizer.TT_EOF) {
                switch (tokenType) {
                    case StreamTokenizer.TT_EOL:
                        index++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        s = st.sval;
                        switch (index) {
                            case 0:
                                result[index] = new File(s);
                                break;
                            case 1:
                                result[index] = s;
                                break;
                            case 2:
                                result[index] = s;
                                break;
                            case 3:
                                result[index] = new Integer(s);
                                break;
                            case 4:
                                result[index] = new Integer(s);
                                break;
                            case 5:
                                result[index] = new Integer(s);
                                break;
                            case 6:
                                result[index] = new Integer(s);
                                break;
                            case 7:
                                result[index] = new Integer(s);
                                break;
                            case 8:
                                result[index] = new Integer(s);
                                break;
                            case 9:
                                result[index] = new Long(s);
                                break;
                            case 10:
                                result[index] = s;
                                break;
                            case 11:
                                result[index] = s;
                                break;
                        }
                        // System.out.println(_String);
                        break;
                }
                tokenType = st.nextToken();
            }
            br.close();
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return result;
    }
}
