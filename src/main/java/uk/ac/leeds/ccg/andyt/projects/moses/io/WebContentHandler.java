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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

/**
 * Class for generating Web Content.
 */
public abstract class WebContentHandler {

    /** Creates a new instance of RegressionPlots */
    public WebContentHandler() {
    }

    public void writeHTML(String _BaseURL, String _Directory,
            String _FilenamePrefix, String _FilenameSuffix,
            int int_MainBodyControlSwitch) throws IOException {
        FileOutputStream _FileOutputStream = new FileOutputStream(new File(
                _Directory, _FilenamePrefix + _FilenameSuffix
                + ".xhtml2.0.html"));
        byte[] _LineSeparator = System.getProperty("line.separator").getBytes();
        writeHTMLDTD(_LineSeparator, _FileOutputStream);
        writeHTMLHead(_LineSeparator, _FilenamePrefix, _FileOutputStream);
        writeHTMLBody(_LineSeparator, _BaseURL, _FilenamePrefix,
                _FilenameSuffix, _FileOutputStream, int_MainBodyControlSwitch);
        _FileOutputStream.flush();
        _FileOutputStream.close();
    }

    public void writeHTML(
            URL a_BaseURL,
            String a_Name,
            File a_File)
            throws IOException {
        a_File.getParentFile().mkdirs();
        FileOutputStream _FileOutputStream = new FileOutputStream(a_File);
        byte[] _LineSeparator = System.getProperty("line.separator").getBytes();
        writeHTMLDTD(
                _LineSeparator,
                _FileOutputStream);
        writeHTMLHead(
                _LineSeparator,
                a_BaseURL,
                a_Name,
                _FileOutputStream);
        writeHTMLBody(
                _LineSeparator,
                a_BaseURL,
                a_Name,
                _FileOutputStream);
        _FileOutputStream.flush();
        _FileOutputStream.close();
    }

    public void writeHTMLBodyFooter(
            byte[] _LineSeparator,
            String _BaseURL,
            String filenamePrefix,
            FileOutputStream _FileOutputStream)
            throws IOException {
        _FileOutputStream.write("<!-- Begin Footer -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<div>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<ul>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- Begin Validation -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- For validating the RDF linked from the header-->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<a href=\"http://www.w3.org/RDF/Validator/ARPServlet?URI="
                + _BaseURL + filenamePrefix + ".rdf.xml\">").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<img src=\"http://www.geog.leeds.ac.uk/people/a.turner/images/rdf_w3c_button.gif\" alt=\"[Validate RDF]\" title=\"W3C RDF Validation\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</a>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- For validating this page. -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!--<a href=\"http://validator.w3.org/check/referer\">".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<img src=\"http://www.geog.leeds.ac.uk/people/a.turner/images/valid-xhtml10.png\" alt=\"[Validate XHTML 2.0]\" title=\"W3C XHTML 2.0 Validation\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</a>-->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- For validating the CSS linked from the header. -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<a href=\"http://jigsaw.w3.org/css-validator/check/referer\">".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<img src=\"http://www.geog.leeds.ac.uk/people/a.turner/images/vcss.gif\" alt=\"[Validate CSS]\" title=\"W3C CSS Validation\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</a>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- End Validation -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li>Page hosted on the <a href=\"http://www.geog.leeds.ac.uk/\" title=\"School of Geography Home Page @ University of Leeds\">School of Geography</a> webserver at the <a href=\"http://www.leeds.ac.uk/\" title=\"University of Leeds Home Page\">University of Leeds</a>.</li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li>Copyright: Andy Turner, University of Leeds</li>".getBytes());
        _FileOutputStream.write("<li>Copyright: Census output is Crown copyright and is reproduced with the permission of the Controller of HMSO and the Queen's Printer for Scotland</li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</ul>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</div>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- End Footer -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</body>".getBytes());
    }

    public void writeHTMLBodyFooter(byte[] _LineSeparator, URL _BaseURL,
            FileOutputStream _FileOutputStream) throws IOException {
        _FileOutputStream.write("<!-- Begin Footer -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<div>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<ul>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- Begin Validation -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- For validating the RDF linked from the header-->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<a href=\"http://www.w3.org/RDF/Validator/ARPServlet?URI="
                + _BaseURL + ".rdf.xml\">").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<img src=\"http://www.geog.leeds.ac.uk/people/a.turner/images/rdf_w3c_button.gif\" alt=\"[Validate RDF]\" title=\"W3C RDF Validation\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</a>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- For validating this page. -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!--<a href=\"http://validator.w3.org/check/referer\">".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<img src=\"http://www.geog.leeds.ac.uk/people/a.turner/images/valid-xhtml10.png\" alt=\"[Validate XHTML 2.0]\" title=\"W3C XHTML 2.0 Validation\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</a>-->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- For validating the CSS linked from the header. -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<a href=\"http://jigsaw.w3.org/css-validator/check/referer\">".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<img src=\"http://www.geog.leeds.ac.uk/people/a.turner/images/vcss.gif\" alt=\"[Validate CSS]\" title=\"W3C CSS Validation\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</a>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- End Validation -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li>Page hosted on the <a href=\"http://www.geog.leeds.ac.uk/\" title=\"School of Geography Home Page @ University of Leeds\">School of Geography</a> webserver at the <a href=\"http://www.leeds.ac.uk/\" title=\"University of Leeds Home Page\">University of Leeds</a>.</li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li>Copyright: Andy Turner, University of Leeds</li>".getBytes());
        _FileOutputStream.write("<li>Copyright: Census output is Crown copyright and is reproduced with the permission of the Controller of HMSO and the Queen's Printer for Scotland</li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</ul>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</div>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!-- End Footer -->".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</body>".getBytes());
    }

    public abstract void writeHTMLBodyMain(byte[] _LineSeparator,
            String _BaseURL, String filenamePrefix, String filenameSuffix,
            FileOutputStream _FileOutputStream, int int_MainBodyControlSwitch)
            throws IOException;

    public abstract void writeHTMLBodyMain(byte[] _LineSeparator, URL _BaseURL,
            FileOutputStream _FileOutputStream) throws IOException;

    public void writeHTMLBodyStart(byte[] _LineSeparator, String _BaseURL,
            String filenamePrefix, String filenameSuffix,
            FileOutputStream _FileOutputStream) throws IOException {
        _FileOutputStream.write("<body>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<div><ul>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<li><h1><a href=\"" + _BaseURL
                + filenamePrefix + filenameSuffix
                + ".xhtml2.0.html\" title=\"Andy Turner's MoSeS "
                + filenamePrefix + filenameSuffix
                + " Page @ School of Geography, University of Leeds\">MoSeS "
                + filenamePrefix + filenameSuffix + " Page</a></h1></li>").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li><h3><a href=\"http://www.geog.leeds.ac.uk/people/a.turner/\" title=\"Andy Turner's Home Page @ School of Geography, University of Leeds\"><img src=\"http://www.geog.leeds.ac.uk/people/a.turner/a.turner.png\" alt=\"[An image of Andy Turner]\" /></a></h3></li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</ul></div>".getBytes());
        _FileOutputStream.write(_LineSeparator);
    }

    public void writeHTMLBodyStart(byte[] _LineSeparator, URL _BaseURL,
            String _Name, FileOutputStream _FileOutputStream)
            throws IOException {
        _FileOutputStream.write("<body>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<div><ul>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<li><h1><a href=\"" + _BaseURL
                + "\">MoSeS " + _Name + " Web Page</a></h1></li>").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<li><h3><a href=\"http://www.geog.leeds.ac.uk/people/a.turner/\" title=\"Andy Turner's Home Page @ School of Geography, University of Leeds\"><img src=\"http://www.geog.leeds.ac.uk/people/a.turner/a.turner.png\" alt=\"[An image of Andy Turner]\" /></a></h3></li>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</ul></div>".getBytes());
        _FileOutputStream.write(_LineSeparator);
    }

    public void writeHTMLBody(byte[] _LineSeparator, String _BaseURL,
            String filenamePrefix, String filenameSuffix,
            FileOutputStream _FileOutputStream, int int_MainBodyControlSwitch)
            throws IOException {
        writeHTMLBodyStart(_LineSeparator, _BaseURL, filenamePrefix,
                filenameSuffix, _FileOutputStream);
        writeHTMLBodyMain(_LineSeparator, _BaseURL, filenamePrefix,
                filenameSuffix, _FileOutputStream, int_MainBodyControlSwitch);
        writeHTMLBodyFooter(_LineSeparator, _BaseURL, filenamePrefix,
                _FileOutputStream);
    }

    public void writeHTMLBody(
            byte[] _LineSeparator,
            URL _BaseURL,
            String _Name,
            FileOutputStream _FileOutputStream)
            throws IOException {
        writeHTMLBodyStart(
                _LineSeparator,
                _BaseURL,
                _Name,
                _FileOutputStream);
        writeHTMLBodyMain(
                _LineSeparator,
                _BaseURL,
                _FileOutputStream);
        writeHTMLBodyFooter(
                _LineSeparator,
                _BaseURL,
                _FileOutputStream);
    }

    public void writeHTMLHead(byte[] _LineSeparator, URL _BaseURL,
            String _Name, FileOutputStream _FileOutputStream)
            throws IOException {
        _FileOutputStream.write("<head>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<link rel=\"schema.DC\" href=\"http://purl.org/dc/elements/1.1/\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.language\" content=\"en\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.format\" content=\"text/html\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.publisher\" content=\"School of Geography, University of Leeds\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.rights\" content=\"http://www.leeds.ac.uk/copyright.html\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<meta name=\"DC.title\" content=\"Andy Turner's "
                + _Name
                + " Web Page @ School of Geography, University of Leeds\" />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<meta name=\"DC.description\" content=\"Andy Turner's "
                + _Name
                + " Web Page @ School of Geography, University of Leeds\" />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        Calendar a_Calendar = Calendar.getInstance();
        _FileOutputStream.write(("<meta name=\"DC.date\" content=\""
                + a_Calendar.get(Calendar.YEAR) + "-"
                + (a_Calendar.get(Calendar.MONTH) + 1) + "-"
                + a_Calendar.get(Calendar.DAY_OF_MONTH) + "\" />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.contributor\" content=\"Andy Turner\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<meta name=\"DC.subject\" content="
                + _Name + " />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.creator\" content=\"Andy Turner\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<title>Andy Turner's "
                + _Name
                + " Web Page @ School of Geography, University of Leeds</title>").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"Keywords\" content=\"Andy Turner,MoSeS,Demography\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"description\" content=\"Project Web Page\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"author\" content=\"Andy Turner\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<link rel=\"stylesheet\" href=\"http://www.geog.leeds.ac.uk/people/a.turner/style/SOGStyle1CSS2.1.css\" type=\"text/css\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</head>".getBytes());
        _FileOutputStream.write(_LineSeparator);
    }

    public void writeHTMLHead(byte[] _LineSeparator, String filenamePrefix,
            FileOutputStream _FileOutputStream) throws IOException {
        _FileOutputStream.write("<head>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<link rel=\"schema.DC\" href=\"http://purl.org/dc/elements/1.1/\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.language\" content=\"en\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.format\" content=\"text/html\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.publisher\" content=\"School of Geography, University of Leeds\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.rights\" content=\"http://www.leeds.ac.uk/copyright.html\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<meta name=\"DC.title\" content=\"Andy Turner's xhtml2.0 MoSeS "
                + filenamePrefix
                + " Page @ School of Geography, University of Leeds\" />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<meta name=\"DC.description\" content=\"Andy Turner's xhtml2.0 MoSeS "
                + filenamePrefix
                + " Page @ School of Geography, University of Leeds\" />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        Calendar a_Calendar = Calendar.getInstance();
        _FileOutputStream.write(("<meta name=\"DC.date\" content=\""
                + a_Calendar.get(Calendar.YEAR) + "-"
                + (a_Calendar.get(Calendar.MONTH) + 1) + "-"
                + a_Calendar.get(Calendar.DAY_OF_MONTH) + "\" />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.contributor\" content=\"Andy Turner\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<meta name=\"DC.subject\" content="
                + filenamePrefix + " />").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"DC.creator\" content=\"Andy Turner\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(("<title>Andy Turner's xhtml2.0 MoSeS "
                + filenamePrefix
                + " Page @ School of Geography, University of Leeds</title>").getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"Keywords\" content=\"Andy Turner,MoSeS,Demography\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"description\" content=\"Project Web Page\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<meta name=\"author\" content=\"Andy Turner\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<link rel=\"stylesheet\" href=\"http://www.geog.leeds.ac.uk/people/a.turner/style/SOGStyle1CSS2.1.css\" type=\"text/css\" />".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("</head>".getBytes());
        _FileOutputStream.write(_LineSeparator);
    }

    public void writeHTMLDTD(byte[] _LineSeparator,
            FileOutputStream _FileOutputStream) throws IOException {
        _FileOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<?xml-stylesheet type=\"text/css\" href=\"http://www.w3.org/MarkUp/style/xhtml2.css\"?>".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 2.0//EN\" \"http://www.w3.org/MarkUp/DTD/xhtml2.dtd\">".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write("<html xmlns=\"http://www.w3.org/2002/06/xhtml2/\" xml:lang=\"en\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"".getBytes());
        _FileOutputStream.write(_LineSeparator);
        _FileOutputStream.write(" xsi:schemaLocation=\"http://www.w3.org/2002/06/xhtml2/ http://www.w3.org/MarkUp/SCHEMA/xhtml2.xsd\">".getBytes());
        _FileOutputStream.write(_LineSeparator);
    }
}
