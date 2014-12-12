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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import javax.imageio.ImageIO;
//import org.geotools.data.FeatureSource;
//import org.geotools.data.shapefile.ShapefileDataStore;
//import org.geotools.data.shapefile.ShapefileDataStoreFactory;
//import org.geotools.feature.Feature;
//import org.geotools.feature.FeatureCollection;
//import org.geotools.feature.FeatureIterator;
//import org.geotools.feature.FeatureType;
//import org.geotools.feature.SimpleFeature;
//import org.geotools.filter.FidFilter;
//import org.geotools.filter.FilterFactoryImpl;
//import org.geotools.map.DefaultMapContext;
//import org.geotools.map.DefaultMapLayer;
//import org.geotools.map.MapContext;
//import org.geotools.map.MapLayer;
//import org.geotools.renderer.lite.LiteRenderer;
//import org.geotools.renderer.shape.ShapefileRenderer;
//import org.geotools.styling.FeatureTypeStyle;
//import org.geotools.styling.PolygonSymbolizer;
//import org.geotools.styling.Rule;
//import org.geotools.styling.Style;
//import org.geotools.styling.StyleBuilder;
//import org.geotools.styling.StyleFactory;
//import org.geotools.styling.StyleFactoryFinder;
//import org.geotools.styling.StyleFactoryImpl;
import uk.ac.leeds.ccg.andyt.projects.moses.io.AbstractOutputDataHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.io.OutputDataHandler_ControlConstraints;
import uk.ac.leeds.ccg.andyt.projects.moses.io.OutputDataHandler_NonConstraints;
import uk.ac.leeds.ccg.andyt.projects.moses.io.OutputDataHandler_OptimisationConstraints;

/**
 * A class for generating maps comparing CAS data with IndividualCensus outputs
 * in the form of geographical maps.
 */
public class MappingReport_1 extends MappingReport {

	public MappingReport_1() {
	}

	String[] _Variables;

	Object[] _Legends;

	// String[] _ImageFileNames;

	String _AreaLevel;

	String _Type;

	/**
	 * @param args
	 *            the command line arguments
     * @throws java.lang.Exception
	 */
	public static void main(String[] args) throws Exception {
		new MappingReport_1().run();
	}

	public void run() throws Exception {
		int _REDAlpha = Color.RED.getAlpha();
		int _REDRed = Color.RED.getRed();
		int _REDGreen = Color.RED.getGreen();
		int _REDBlue = Color.RED.getBlue();
		float[] _REDHSB = new float[3];
		Color.RGBtoHSB(_REDRed, _REDGreen, _REDBlue, _REDHSB);

		int _RGB = Color.HSBtoRGB(_REDHSB[0], _REDHSB[1], _REDHSB[2]);

		Color _Color = new Color(_RGB);

		int _ColorAlpha = _Color.getAlpha();
		int _ColorRed = _Color.getRed();
		int _ColorGreen = _Color.getGreen();
		int _ColorBlue = _Color.getBlue();

		// run( "ControlConstraints", "SSE" );
		// run( "OptimisationConstraints", "SSE" );
		// run( "NonConstraints", "SSE" );
		// run( "ControlConstraints", "NSSE" );
		run("OptimisationConstraints", "NSSE");
		// run( "NonConstraints", "NSSE" );
	}

	public void run(String _Type, String _ErrorFunction) throws Exception {
		this._Type = _Type;
		String _OutputDirectoryName_1 = "C:/temp/"; // Because
																// filename
																// length is a
																// problem!
		String _OutputName = "ToyModel_SWR_OA_HSARHP_ISARCEP_0_10_3000_10_100_12_10";
		String _OutputDirectoryName_2 = _OutputDirectoryName_1
                        + _ErrorFunction + "/" + _OutputName + "/";
		File _InputFile = new File(_OutputDirectoryName_2, _OutputName + ".csv");

		String _InputDirectoryName = "C:/Work/Projects/MoSeS/Workspace/";

		AbstractOutputDataHandler _OutputDataHandler = null;
		if (_Type.equalsIgnoreCase("ControlConstraints")) {
			_OutputDataHandler = new OutputDataHandler_ControlConstraints();
		}
		if (_Type.equalsIgnoreCase("OptimisationConstraints")) {
			//_OutputDataHandler = new OutputDataHandler_OptimisationConstraints();
		}
		if (_Type.equalsIgnoreCase("NonConstraints")) {
			_OutputDataHandler = new OutputDataHandler_NonConstraints();
		}

		this._AreaLevel = "OA"; // MSOA,Ward
		String _Area = "Leeds"; // UK
		long _StartRecordID = 56749L;// 0
		long _EndRecordID = _StartRecordID + 2438L;// 175433
		String _OutputFileName;

		// Observed
		_OutputFileName = _InputDirectoryName + "/" + _Area + "/"
                        + _Type + "/" + _AreaLevel + ".csv";
		File _ObservedFile = new File(_OutputFileName);
		// _OutputDataHandler.writeObserved(
		// _InputDirectoryName,
		// _OutputFileName,
		// _StartRecordID,
		// _EndRecordID,
		// _AreaLevel );

		// Estimated
		_OutputFileName = _OutputDirectoryName_2 + "/" + _Area + "/"
                        + _Type + "/" + _AreaLevel + ".csv";
		File _EstimatedFile = new File(_OutputFileName);
		// _OutputDataHandler.writeEstimated_HSARHP(
		// _InputFile,
		// _EstimatedFile,
		// _AreaLevel );

		// URL _BaseURL_1 = new URL(
		// "http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS/documentation/demography/results/2001PopulationInitialisation/"
		// );
		URL _BaseURL_2 = new URL(
				"http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS/documentation/demography/results/2001PopulationInitialisation/"
						+ _ErrorFunction
						+ "/"
						+ _OutputName
						+ "/"
						+ _Area
						+ "/"
						+ _Type
						+ "/"
						+ _AreaLevel
						+ "ErrorMaps.xhtml2.0.html");
		int _Chart_Width = 500; // 2000
		int _Chart_Height = 500; // 2000
		// this._ImageFileNames = outputImages( _ObservedFile, _EstimatedFile,
		// _EstimatedFile.getParentFile(), _Chart_Width, _Chart_Height );
//		outputImages(_ObservedFile, _EstimatedFile, _EstimatedFile
//				.getParentFile(), _Chart_Width, _Chart_Height);
		_OutputFileName = _OutputDirectoryName_2 + "/" + _Area + "/"
                        + _Type + "/" + _AreaLevel + "ErrorMaps" + ".xhtml2.0.html";
		writeHTML(_BaseURL_2, _OutputName + " " + _Area + " " + _Type + " "
				+ _AreaLevel + " Error Maps", new File(_OutputFileName));
	}

	// public String[] outputImages(
//	public void outputImages(File _File_Observed, File _File_Expected,
//			File _OutputDirectory, int _Width, int _Height) throws Exception {
//		String[] result;
//		Object[] _Data = loadData(_File_Expected, _File_Observed);
//		this._Variables = (String[]) _Data[0];
//		double[][] _SARExpectedData = (double[][]) _Data[1];
//		double[][] _CASObservedData = (double[][]) _Data[2];
//		Vector _ZoneCodes = (Vector) _Data[3];
//		double[] _SARExpectedData0 = _SARExpectedData[0];
//		result = new String[_SARExpectedData0.length];
//		this._Legends = new Object[_SARExpectedData0.length];
//		// double[] _CASObservedData0 = _CASObservedData[0];
//		double[][] _Errors = new double[_SARExpectedData.length][_SARExpectedData0.length];
//		for (int i = 0; i < _SARExpectedData.length; i++) {
//			HashMap _ErrorToMap = new HashMap();
//			Object[] _Legend = new Object[4];
//			for (int j = 0; j < _SARExpectedData0.length; j++) {
//				_Errors[i][j] = (_SARExpectedData[i][j] - _CASObservedData[i][j])
//						* (_SARExpectedData[i][j] - _CASObservedData[i][j]);
//				_ErrorToMap.put(_ZoneCodes.elementAt(j), _Errors[i][j]);
//				// System.out.println( "Error for " + this._Variables[ ( i + 1 )
//				// ] + " for _ZoneCode " + _ZoneCodes.elementAt( j ) + " = " +
//				// _Errors[ i ][ j ] );
//			}
//
//			// // Not used as seemingly no way to get at attribute information.
//			// // Read Boundary data using ShapefileReader.
//			// File _File = new File(
//			// "C:/Work/data/Census/2001/Boundaries/Leeds_oa/England_oa_2001_area.shp"
//			// );
//			// FileInputStream _FileInputStream = new FileInputStream( _File );
//			// FileChannel _FileChannel = _FileInputStream.getChannel();
//			// Lock _Lock = new Lock();
//			// ShapefileReader _ShapefileReader = new ShapefileReader(
//			// _FileChannel, _Lock );
//			// ShapefileHeader _ShapefileHeader = _ShapefileReader.getHeader();
//			// System.out.println( _ShapefileHeader.toString() );
//			// Record _Record;
//			// while ( _ShapefileReader.hasNext() ) {
//			// _Record = _ShapefileReader.nextRecord();
//			// System.out.println( _Record.toString() );
//			// }
//
//			// Read Boundary data using ShapefileDataStore
//			URL _URL = new URL(
//					"file:///C:/Work/data/Census/2001/Boundaries/Leeds_oa/England_oa_2001_area.shp");
//			// boolean readDBF = true;
//			ShapefileDataStoreFactory _ShapefileDataStoreFactory = new ShapefileDataStoreFactory();
//			ShapefileDataStore _ShapefileDataStore = (ShapefileDataStore) _ShapefileDataStoreFactory
//					.createDataStore(_URL);
//			// ShapefileDataStore _ShapefileDataStore = new ShapefileDataStore(
//			// _URL );
//			FeatureType _FeatureType = _ShapefileDataStore.getSchema();
//			// System.out.println(
//			// _FeatureType.getDefaultGeometry().getCoordinateSystem() );
//			// AttributeType[] _AttributeTypes =
//			// _FeatureType.getAttributeTypes();
//			// for ( int i = 0; i < _AttributeTypes.length; i ++ ) {
//			// System.out.println( _AttributeTypes[ i ].getName() );
//			// }
//			FeatureSource _FeatureSource = _ShapefileDataStore
//					.getFeatureSource();
//			FeatureCollection _FeatureCollection = _FeatureSource.getFeatures();
//			Object[] _Attributes = _FeatureCollection
//					.getAttributes(new Object[_FeatureCollection
//							.getNumberOfAttributes()]);
//			// for ( int i = 0; i < _Attributes.length; i ++ ) {
//			// //System.out.println( _AttributeTypes[ i ].getClass().cast(
//			// _Attributes[ i ] ).toString() );
//			// System.out.println( _Attributes[ i ].toString() );
//			// }
//			FeatureIterator _FeatureIterator = _FeatureCollection.features();
//			Feature _Feature;
//			String[] _ONS_LABELs = new String[_Attributes.length];
//
//			// Hashtable _Hashtable = new Hashtable();
//			// HashMap _HashMap = new HashMap();
//			HashMap _HashMapPositive = new HashMap();
//			HashMap _HashMapNegative = new HashMap();
//
//			Vector _ONS_LABELSPositiveVector = new Vector();
//			Vector _ONS_LABELSNegativeVector = new Vector();
//
//			int _NumberOfFeatures = 0;
//			// String _FeatureTypeName;
//			while (_FeatureIterator.hasNext()) {
//				_Feature = _FeatureIterator.next();
//				// System.out.println( _Feature.toString() );
//				_ONS_LABELs[_NumberOfFeatures] = _Feature.getAttribute(
//						"ONS_LABEL").toString();
//				_NumberOfFeatures++;
//				// _FeatureTypeName = _Feature.getFeatureType().getTypeName();
//				// System.out.println( "_FeatureTypeName " + _FeatureTypeName );
//				// _Hashtable.put( _Feature.getAttribute( "ONS_LABEL"
//				// ).toString(), ( float ) ( Math.random() * 100 ) );
//				// _HashMap.put( _Feature.getAttribute( "ONS_LABEL"
//				// ).toString(), ( ( Double ) _ErrorToMap.get(
//				// _Feature.getAttribute( "ONS_LABEL" ).toString() )
//				// ).floatValue() );
//				float _ErrorFloat = ((Double) _ErrorToMap.get(_Feature
//						.getAttribute("ONS_LABEL").toString())).floatValue();
//				String ONS_LABEL = _Feature.getAttribute("ONS_LABEL")
//						.toString();
//				if (_ErrorFloat > 0) {
//					_HashMapPositive.put(ONS_LABEL, ((Double) _ErrorToMap
//							.get(ONS_LABEL)).floatValue());
//					_ONS_LABELSPositiveVector.add(ONS_LABEL);
//				} else {
//					_HashMapNegative.put(ONS_LABEL, ((Double) _ErrorToMap
//							.get(ONS_LABEL)).floatValue());
//					_ONS_LABELSNegativeVector.add(ONS_LABEL);
//				}
//				// System.out.println( _Feature.getAttribute( "ONS_LABEL"
//				// ).toString() );
//			}
//
//			String[] _ONS_LABELSPositiveArray = new String[_ONS_LABELSPositiveVector
//					.size()];
//			for (int ii = 0; ii < _ONS_LABELSPositiveVector.size(); ii++) {
//				_ONS_LABELSPositiveArray[ii] = (String) _ONS_LABELSPositiveVector
//						.elementAt(ii);
//			}
//			String[] _ONS_LABELSNegativeArray = new String[_ONS_LABELSNegativeVector
//					.size()];
//			for (int ii = 0; ii < _ONS_LABELSNegativeVector.size(); ii++) {
//				_ONS_LABELSNegativeArray[ii] = (String) _ONS_LABELSNegativeVector
//						.elementAt(ii);
//			}
//
//			if (_NumberOfFeatures != _Attributes.length) {
//				System.out.println("DEBUG");
//			}
//
//			// Create image using _ShapefileRenderer
//			ShapefileRenderer _ShapefileRenderer = new ShapefileRenderer();
//			_ShapefileRenderer.useIndex(_ShapefileDataStore);
//
//			// Set _MapContext
//			// CRS _CRS = new CRS();
//			// CoordinateReferenceSystem _CoordinateReferenceSystem = new
//			// CoordinateReferenceSystem();
//			// DefaultMapContext context = new DefaultMapContext(
//			// _CoordinateReferenceSystem );
//			DefaultMapContext _MapContext = new DefaultMapContext();
//			// // Set some extra information to the map
//			// _MapContext.setTitle( "_Title" );
//			// _MapContext.setContactInformation( "_ContactInformation" );
//			// _MapContext.setAbstract( "_Abstract" );
//
//			// Create _Style
//			StyleFactoryImpl _StyleFactoryImpl = new StyleFactoryImpl();
//			PolygonSymbolizer _PolygonSymbolizer = _StyleFactoryImpl
//					.createPolygonSymbolizer();
//
//			// // Map boundaries
//			// Rule _Rule = _StyleFactoryImpl.createRule();
//			// _Rule.setSymbolizers( new Symbolizer[] { _PolygonSymbolizer } );
//			// Style _Style = _StyleFactoryImpl.createStyle();
//			// _Style.setName( "Style" );
//			// _Style.addFeatureTypeStyle(
//			// _StyleFactoryImpl.createFeatureTypeStyle( new Rule[] { _Rule } )
//			// );
//			// MapLayer _MapLayer = new DefaultMapLayer( _FeatureCollection,
//			// _Style, "_MapLayer1");
//			// _MapContext.addLayer( _MapLayer );
//			// createPNGImage(_MapContext, _Width, _Height, new File(
//			// "C:/Work/data/Census/2001/Boundaries/Leeds_oa/England_oa_2001_area.PNG"
//			// ).toString() );
//
//			// find min and max results
//			float minResult = Float.MAX_VALUE;
//			float maxResult = Float.MIN_VALUE;
//			for (int count = 0; count < _NumberOfFeatures; count++) {
//				Float currentResult;
//				// currentResult = ( ( Float ) _Hashtable.get( _ONS_LABELs[
//				// count ] ) );
//				// currentResult = ( ( Float ) _HashMap.get( _ONS_LABELs[ count
//				// ] ) );
//				if (_HashMapPositive.containsKey(_ONS_LABELs[count])) {
//					currentResult = ((Float) _HashMapPositive
//							.get(_ONS_LABELs[count]));
//				} else {
//					currentResult = ((Float) _HashMapNegative
//							.get(_ONS_LABELs[count]));
//				}
//				if (currentResult < minResult)
//					minResult = (float) currentResult;
//				if (currentResult > maxResult)
//					maxResult = (float) currentResult;
//			}
//			HashMap _ZoneFidsLookupHashMap = getZoneFidsLookupHashMap(_FeatureCollection);
//			_Legend[0] = new Float(minResult);
//			_Legend[1] = new Float(maxResult);
//
//			// Color[] _Colors = generateColourArray( _ONS_LABELs, minResult,
//			// maxResult, _Hashtable );
//			// Color[] _Colors = generateColourArray( _ONS_LABELs, minResult,
//			// maxResult, _HashMap );
//			float hue;
//
//			hue = (1f / 255f) * 200f; // 200
//
//			Color[] _ColorsNegative = generateColourArray(hue,
//					_ONS_LABELSNegativeArray, minResult, 0f, _HashMapNegative);
//
//			hue = (1f / 255f) * 150f; // 200
//
//			Color[] _ColorsPositive = generateColourArray(hue,
//					_ONS_LABELSPositiveArray, 0f, maxResult, _HashMapPositive);
//
//			// _Legend[2] = _Colors;
//			_Legend[2] = _ColorsNegative;
//			_Legend[3] = _ColorsPositive;
//
//			this._Legends[i] = _Legend;
//
//			// Create array of rules applying arrayOfMapColours colour to
//			// equivalent in selectedZones
//			StyleBuilder _StyleBuilder = new StyleBuilder();
//			StyleFactoryFinder _StyleFactoryFinder = new StyleFactoryFinder();
//			StyleFactory _StyleFactory = _StyleFactoryFinder
//					.createStyleFactory();
//			FilterFactoryImpl _FilterFactory = new FilterFactoryImpl();
//			Style _Style = _StyleBuilder.createStyle();
//			FeatureTypeStyle _FeatureTypeStyle = _StyleFactory
//					.createFeatureTypeStyle();
//			// _FeatureTypeStyle.setFeatureTypeName( _FeatureTypeName );
//			// _FeatureTypeStyle.setFeatureTypeName( "England_oa_2001_area" );
//			int _ColorPositiveIndex = 0;
//			int _ColorNegativeIndex = 0;
//			for (int count = 0; count < _NumberOfFeatures; count++) {
//				PolygonSymbolizer[] _PolygonSymbolizers = new PolygonSymbolizer[1];
//				if (_HashMapPositive.containsKey(_ONS_LABELs[count])) {
//					_PolygonSymbolizers[0] = _StyleBuilder
//							.createPolygonSymbolizer(
//									_ColorsPositive[_ColorPositiveIndex],
//									Color.lightGray, // Color.ORANGE, null,
//														// Color.OPAQUE
//									0);
//					_ColorPositiveIndex++;
//				} else {
//					_PolygonSymbolizers[0] = _StyleBuilder
//							.createPolygonSymbolizer(
//									_ColorsNegative[_ColorNegativeIndex],
//									Color.lightGray, // Color.ORANGE, null,
//														// Color.OPAQUE
//									0);
//					_ColorNegativeIndex++;
//				}
//				// _PolygonSymbolizers[0] =
//				// _StyleBuilder.createPolygonSymbolizer(
//				// _Colors[count],
//				// Color.lightGray, //Color.ORANGE, null, Color.OPAQUE
//				// 0);
//				Rule _Rule = _StyleFactory.createRule();
//				_Rule.setName("ZoneStyle" + _ONS_LABELs[count]);
//				FidFilter _ZoneFilter = _FilterFactory.createFidFilter();
//				_Rule.setFilter(_ZoneFilter);
//				_Rule.setSymbolizers(_PolygonSymbolizers);
//
//				HashSet _HashSet = (HashSet) _ZoneFidsLookupHashMap
//						.get(_ONS_LABELs[count]);
//				Iterator _Iterator = _HashSet.iterator();
//				while (_Iterator.hasNext()) {
//					_ZoneFilter.addFid((String) _Iterator.next());
//				}
//
//				// _ZoneFilter.addFid( ( String ) _HashtableLookups.get(
//				// _ONS_LABEL[ count ] ) );
//				// System.out.println( "Fid returned = " + ( String )
//				// _HashtableLookups.get( _ONS_LABEL[ count ] ) );
//				_FeatureTypeStyle.addRule(_Rule);
//			}
//			_Style.addFeatureTypeStyle(_FeatureTypeStyle);
//			MapLayer _MapLayer = new DefaultMapLayer(_FeatureCollection, _Style);
//			_MapContext.addLayer(_MapLayer);
//			// result[ i ] = "Error " + this._Variables[ ( i + 1 ) ] + ".PNG";
//			// createPNGImage( _MapContext, _Width, _Height, new File(
//			// _OutputDirectory, result[ i ] ) );
//			createPNGImage(_MapContext, _Width, _Height, new File(
//					_OutputDirectory, "Error" + this._AreaLevel + "_"
//							+ this._Variables[(i + 1)] + ".PNG"));
//		}
//		// return result;
//	}

	public void writeHTMLBodyMain(byte[] _LineSeparator, URL _BaseURL,
			FileOutputStream a_FileOutputStream) throws IOException {
		writeHTMLBodyMain1(_LineSeparator, _BaseURL, a_FileOutputStream);
	}

	public void writeHTMLBodyMain(byte[] _LineSeparator, String _BaseURL,
			String filenamePrefix, String filenameSuffix,
			FileOutputStream a_FileOutputStream, int int_MainBodyControlSwitch)
			throws IOException {
		if (int_MainBodyControlSwitch == 1) {
			writeHTMLBodyMain1(_LineSeparator, _BaseURL, filenamePrefix,
					filenameSuffix, a_FileOutputStream);
		}
	}

	public void writeHTMLBodyMain1(byte[] _LineSeparator, String _BaseURL,
			String filenamePrefix, String filenameSuffix,
			FileOutputStream a_FileOutputStream) throws IOException {
	}

	public void writeHTMLBodyMain1(byte[] _LineSeparator, URL _BaseURL,
			FileOutputStream a_FileOutputStream) throws IOException {
		a_FileOutputStream.write(_LineSeparator);
		a_FileOutputStream.write("<div>".getBytes());
		a_FileOutputStream.write(_LineSeparator);
		a_FileOutputStream.write("<ul>".getBytes());
		a_FileOutputStream.write(_LineSeparator);
		a_FileOutputStream.write(("<li><h2>" + this._Type + "</h2>")
				.getBytes());
		a_FileOutputStream.write(_LineSeparator);
		a_FileOutputStream.write("<ul>".getBytes());
		for (int i = 0; i < this._Variables.length - 1; i++) {
			a_FileOutputStream.write(_LineSeparator);
			a_FileOutputStream.write(("<li><h3>"
                                + this._Variables[(i + 1)] + "</h3>").getBytes());
			a_FileOutputStream.write(_LineSeparator);
			a_FileOutputStream.write("<ul>".getBytes());
			a_FileOutputStream.write(_LineSeparator);
			a_FileOutputStream.write(("<li><img src=\"" + "Error"
                                + this._AreaLevel + "_" + this._Variables[(i + 1)]
                                + ".PNG\" /></li>").getBytes());
			a_FileOutputStream.write(_LineSeparator);
			Object[] _Legend = (Object[]) this._Legends[(i + 1)];
			a_FileOutputStream.write(("<li>Min "
                                + (Float) _Legends[0] + " </li>").getBytes());
			a_FileOutputStream.write(_LineSeparator);
			Color[] _Colors = (Color[]) _Legends[2];
			a_FileOutputStream.write(("<li>Number of Colours "
                                + _Colors.length + " </li>").getBytes());
			a_FileOutputStream.write(_LineSeparator);
			a_FileOutputStream.write(("<li>Max "
                                + (Float) _Legends[1] + " </li>").getBytes());
			a_FileOutputStream.write(_LineSeparator);
			a_FileOutputStream.write("</ul></li>".getBytes());
			a_FileOutputStream.write(_LineSeparator);
		}
		a_FileOutputStream.write("</ul></li>".getBytes());
		a_FileOutputStream.write(_LineSeparator);
		a_FileOutputStream.write("</ul>".getBytes());
		a_FileOutputStream.write(_LineSeparator);
		a_FileOutputStream.write("</div>".getBytes());
		a_FileOutputStream.write(_LineSeparator);
	}

//	public void createPNGImage(MapContext theMapContext, final int sizeX,
//			final int sizeY, String _FileName) throws IOException {
//		createPNGImage(theMapContext, sizeX, sizeY, new File(_FileName));
//	}
//
//	public void createPNGImage(MapContext theMapContext, final int sizeX,
//			final int sizeY, File _File) throws IOException {
//		LiteRenderer theLiteRenderer = new LiteRenderer(theMapContext);
//		final Panel thePanel = new Panel();
//		thePanel.setSize(sizeX, sizeY);
//		final ShapefileRenderer theSFRenderer = new ShapefileRenderer(
//				theMapContext);
//		final AffineTransform theTransform = theLiteRenderer
//				.worldToScreenTransform(theMapContext.getAreaOfInterest(),
//						thePanel.getBounds());
//		// image creation
//		BufferedImage bufferedImage = new BufferedImage(sizeX, sizeY,
//				BufferedImage.TYPE_INT_ARGB) {
//			{
//				paint((Graphics2D) getGraphics());
//			}
//
//			private void paint(final Graphics2D graphics2D) {
//				graphics2D.setRenderingHints(new RenderingHints(
//						RenderingHints.KEY_ANTIALIASING,
//						RenderingHints.VALUE_ANTIALIAS_ON));
//				graphics2D.setColor(new Color(0, 0, 0, 0));
//				graphics2D.fillRect(0, 0, sizeX, sizeY);
//				theSFRenderer.paint(graphics2D, thePanel.getBounds(),
//						theTransform);
//			}
//		};
//		try {
//			ImageIO.write(bufferedImage, "PNG", _File);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void createPNGImage2(MapContext _MapContext, final int sizeX,
//			final int sizeY, File _File) throws IOException {
//		System.out
//				.println("Warning!: createPNGImage2(MapContext,int,int,File) not implemented!");
//		// LiteRenderer theLiteRenderer = new LiteRenderer( _MapContext );
//		//
//		// // Create the map pane and add a map scale layer to it.
//		// JMapPane _JMapPane = new JMapPane();
//		// _JMapPane.setContext( _MapContext);
//		// //_JMapPane.getRenderer().addLayer(new RenderedMapScale());
//		//
//		// // create the legend
//		// Legend _Legend = new Legend( _MapContext, "Legend" );
//		//
//		// JPanel _JPanel = new JPanel();
//		// _JPanel.setLayout(new BorderLayout());
//		// _JPanel.add(splitPane, BorderLayout.CENTER);
//		// _JPanel.add(statusBar, BorderLayout.SOUTH);
//		//
//		// // layout the form
//		// JSplitPane splitPane = new JSplitPane();
//		// splitPane.setLeftComponent(legend);
//		// splitPane.setRightComponent(mapPane.createScrollPane());
//		//
//		// thePanel.setSize(sizeX,sizeY);
//		// final ShapefileRenderer theSFRenderer = new ShapefileRenderer(
//		// _MapContext );
//		// final AffineTransform theTransform =
//		// theLiteRenderer.worldToScreenTransform(theMapContext.getAreaOfInterest(),
//		// thePanel.getBounds());
//		// // image creation
//		// BufferedImage bufferedImage = new BufferedImage(sizeX, sizeY,
//		// BufferedImage.TYPE_INT_ARGB) {
//		// {
//		// paint((Graphics2D) getGraphics());
//		// }
//		// private void paint(final Graphics2D graphics2D) {
//		// graphics2D.setRenderingHints(new RenderingHints
//		// (RenderingHints.KEY_ANTIALIASING,
//		// RenderingHints.VALUE_ANTIALIAS_ON));
//		// graphics2D.setColor(new Color(0,0,0,0));
//		// graphics2D.fillRect(0, 0, sizeX, sizeY);
//		// theSFRenderer.paint(graphics2D, thePanel.getBounds(), theTransform);
//		// }
//		// };
//		// try {
//		// ImageIO.write(bufferedImage, "PNG", _File );
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// }
//	}

	private Color[] generateColourArray(String[] selectedZones,
			float minResult, float maxResult, HashMap theResults) {
		// float hue = (1f/255f) * 223f;
		float hue = (1f / 255f) * 150f; // 200
		return generateColourArray(hue, selectedZones, minResult, maxResult,
				theResults);
	}

	private Color[] generateColourArray(float hue, String[] selectedZones,
			float minResult, float maxResult, HashMap theResults) {
		Color[] arrayOfMapColours = new Color[selectedZones.length];
		// float saturation = (1f/255f) * 250f;
		float saturation = (1f / 255f) * 255f;// 200
		float range = maxResult - minResult;
		float startBrightness = 200;
		float endBrightness = 50;
		float unitIncrement = (endBrightness - startBrightness) / range;
		for (int count = 0; count < selectedZones.length; count++) {
			// for (int count = 0; count < theResults.size(); count++) {
			Float currentResult = ((Float) theResults.get(selectedZones[count]));
			float currentMinusMin = (float) (currentResult - minResult);
			float brightness = (float) ((currentMinusMin * unitIncrement) + startBrightness);
			brightness = (1f / 255f) * brightness;
			arrayOfMapColours[count] = Color.getHSBColor(hue, saturation,
					brightness);
		}
		return arrayOfMapColours;
	}

//	private HashMap getZoneFidsLookupHashMap(
//			FeatureCollection _FeatureCollection) {
//		HashMap _HashMap = new HashMap();
//		Iterator _Iterator = _FeatureCollection.iterator();
//		try {
//			while (_Iterator.hasNext()) {
//				SimpleFeature _Feature = (SimpleFeature) _Iterator.next();
//				FeatureType _FeatureType = _Feature.getFeatureType();
//				Object zone = _Feature.getAttribute(_FeatureType
//						.find("ONS_LABEL"));
//				if (_HashMap.containsKey(zone)) {
//					HashSet _HashSet = (HashSet) _HashMap.get(zone);
//					_HashSet.add(_Feature.getID());
//					_HashMap.put(zone, _HashSet); // Not sure this is necessary!
//				} else {
//					HashSet _HashSet = new HashSet();
//					_HashSet.add(_Feature.getID());
//					_HashMap.put(zone, _HashSet);
//				}
//			}
//		} finally {
//			_FeatureCollection.close(_Iterator);
//		}
//		return _HashMap;
//	}

}
