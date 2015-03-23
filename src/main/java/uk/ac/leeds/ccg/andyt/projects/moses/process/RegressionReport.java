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
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Vector;
import org.apache.commons.math.stat.regression.SimpleRegression; //import org.eclipse.swt.SWT;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import uk.ac.leeds.ccg.andyt.projects.moses.io.WebContentHandler;
import uk.ac.leeds.ccg.andyt.generic.io.StaticIO;

/**
 * A class for generating maps comparing CAS data with IndividualCensus outputs
 * in the form of regression plots.
 */
public abstract class RegressionReport extends WebContentHandler {

    public RegressionReport() {
    }

    // public void runWard(
    // String baseURL,
    // String directoryCASObserved,
    // String directory,
    // String filenamePrefix,
    // String filenameSuffix,
    // String aOutputName,
    // int int_MainBodyControlSwitch )
    // throws Exception {
    // String filenameMidfix = new String( "_" + aOutputName + "Ward" );
    // Object[] _Data = loadData(
    // new File( directory + filenamePrefix, filenamePrefix + filenameMidfix +
    // ".csv" ),
    // new File( directoryCASObserved, aOutputName + "Ward.csv" ) );
    // String[] _Variables = ( String[] ) _Data[ 0 ];
    // double[][] _SARExpectedData = ( double[][] ) _Data[1];
    // double[][] _CASObservedData = ( double[][] ) _Data[2];
    // String xAxisLabel = new String( "CAS Estimation (Observed)" );
    // String yAxisLabel = new String( "SAR Prediction (Expected)" );
    // JFreeChart[] _ScatterPlots = createScatterPlots( _Variables,
    // _SARExpectedData, _CASObservedData, xAxisLabel, yAxisLabel );
    // Object[] _RegressionParametersAndCreateXYLineCharts =
    // getRegressionParametersAndCreateXYLineCharts( _Variables,
    // _SARExpectedData, _CASObservedData );
    // JFreeChart[] _RegressionCharts = createRegressionCharts( _ScatterPlots,
    // _RegressionParametersAndCreateXYLineCharts );
    // String type = "PNG";
    // //outputImages( _ScatterPlots, directory + filenamePrefix +
    // "_ScatterPlot", type );
    // //outputImages( _XYLineCharts, directory + filenamePrefix +
    // "_XYLineChart", type );
    // outputImages( _RegressionCharts, 500, 500, directory + filenamePrefix +
    // "/", filenamePrefix + filenameMidfix + "_RegressionChart", type );
    // writeHTML( baseURL, directory + filenamePrefix + "/", filenamePrefix +
    // filenameMidfix, filenameSuffix, int_MainBodyControlSwitch );
    // }
    // public void runMSOA(
    // String baseURL,
    // String directoryCASObserved,
    // String directory,
    // String filenamePrefix,
    // String filenameSuffix,
    // String aOutputName,
    // int int_MainBodyControlSwitch )
    // throws Exception {
    // String filenameMidfix = new String( "_" + aOutputName + "MSOA" );
    // Object[] _Data = loadData(
    // new File( directory + filenamePrefix, filenamePrefix + filenameMidfix +
    // ".csv" ),
    // new File( directoryCASObserved, aOutputName + "MSOA.csv" ) );
    // String[] _Variables = ( String[] ) _Data[ 0 ];
    // double[][] _SARExpectedData = ( double[][] ) _Data[1];
    // double[][] _CASObservedData = ( double[][] ) _Data[2];
    // String xAxisLabel = new String( "CAS Estimation (Observed)" );
    // String yAxisLabel = new String( "SAR Prediction (Expected)" );
    // JFreeChart[] _ScatterPlots = createScatterPlots( _Variables,
    // _SARExpectedData, _CASObservedData, xAxisLabel, yAxisLabel );
    // Object[] _RegressionParametersAndCreateXYLineCharts =
    // getRegressionParametersAndCreateXYLineCharts( _Variables,
    // _SARExpectedData, _CASObservedData );
    // JFreeChart[] _RegressionCharts = createRegressionCharts( _ScatterPlots,
    // _RegressionParametersAndCreateXYLineCharts );
    // String type = "PNG";
    // //outputImages( _ScatterPlots, directory + filenamePrefix +
    // "_ScatterPlot", type );
    // //outputImages( _XYLineCharts, directory + filenamePrefix +
    // "_XYLineChart", type );
    // outputImages( _RegressionCharts, 500, 500, directory + filenamePrefix +
    // "/", filenamePrefix + filenameMidfix + "_RegressionChart", type );
    // writeHTML( baseURL, directory + filenamePrefix + "/", filenamePrefix +
    // filenameMidfix, filenameSuffix, int_MainBodyControlSwitch );
    // }
    public static JFreeChart[] createRegressionCharts(
            JFreeChart[] t_ScatterPlots,
            Object[] t_RegressionParametersAndXYLineCharts)
            throws IOException {
        JFreeChart[] result = new JFreeChart[t_ScatterPlots.length];
        Object[] t_RegressionParameters = (Object[]) t_RegressionParametersAndXYLineCharts[0];
        JFreeChart[] t_regressionXYLineCharts = (JFreeChart[]) t_RegressionParametersAndXYLineCharts[1];
        JFreeChart[] t_yequalsxXYLineCharts = (JFreeChart[]) t_RegressionParametersAndXYLineCharts[2];
        for (int i = 0; i < result.length; i++) {
            double[] a_RegressionParameters = (double[]) t_RegressionParameters[i];
            int maxLengthOfIntString = 6;
            String b = String.valueOf(a_RegressionParameters[0]);
            String a = String.valueOf(a_RegressionParameters[1]);
            String rsquare = String.valueOf(a_RegressionParameters[2]);
            String title = "Y="
                    + a.substring(0, Math.min(a.length(),
                    maxLengthOfIntString)) + "X";
            if (a_RegressionParameters[0] < 0) {
                title += b.substring(0, Math.min(b.length(),
                        maxLengthOfIntString));
            } else {
                title += "+"
                        + b.substring(0, Math.min(b.length(),
                        maxLengthOfIntString));
            }
            if (a_RegressionParameters.length > 2) {
                title += "    RSquare "
                        + rsquare.substring(0, Math.min(rsquare.length(),
                        maxLengthOfIntString));
            }
            XYLineAndShapeRenderer points_XYLineAndShapeRenderer = new XYLineAndShapeRenderer(
                    false, true);
            XYPlot a_ScatterPlotXYPlot = (XYPlot) t_ScatterPlots[i].getPlot();
            a_ScatterPlotXYPlot.setDataset(0, a_ScatterPlotXYPlot.getDataset());
            points_XYLineAndShapeRenderer.setSeriesPaint(0, Color.blue);

            Shape[] _Shapes = DefaultDrawingSupplier.createStandardSeriesShapes();
            // System.out.println("There are " + _Shapes.length +
            // " number of Shapes to try...");
            // 0 are square
            // 1 are circles
            // 2 are up-pointing triangle
            // 3 are diamond
            // 4 are horizontal rectangle
            // 5 are down-pointing triangle
            // 6 are horizontal ellipse
            // 7 are right-pointing triangle
            // 8 are vertical rectangle
            // 9 are left-pointing triangle
            int a_SpikeLength = 3;
            int[] xpoints = new int[9];
            int[] ypoints = new int[9];
            xpoints[0] = 0;
            ypoints[0] = 0;
            xpoints[1] = 0;
            ypoints[1] = a_SpikeLength;
            xpoints[2] = 0;
            ypoints[2] = 0;
            xpoints[3] = a_SpikeLength;
            ypoints[3] = 0;
            xpoints[4] = 0;
            ypoints[4] = 0;
            xpoints[5] = 0;
            ypoints[5] = -a_SpikeLength;
            xpoints[6] = 0;
            ypoints[6] = 0;
            xpoints[7] = -a_SpikeLength;
            ypoints[7] = 0;
            xpoints[8] = 0;
            ypoints[8] = 0;
            Shape a_Shape = new Polygon(xpoints, ypoints, xpoints.length);
            // points_XYLineAndShapeRenderer.setSeriesShape( 0, _Shapes[2] );
            points_XYLineAndShapeRenderer.setSeriesShape(0, a_Shape);
            a_ScatterPlotXYPlot.setRenderer(0, points_XYLineAndShapeRenderer);

            XYDataset a_regressionXYLineChartXYDataset = ((XYPlot) t_regressionXYLineCharts[i].getPlot()).getDataset();
            XYLineAndShapeRenderer line_XYLineAndShapeRenderer = new XYLineAndShapeRenderer(
                    true, false);
            a_ScatterPlotXYPlot.setDataset(1, a_regressionXYLineChartXYDataset);
            line_XYLineAndShapeRenderer.setPaint(Color.red);
            a_ScatterPlotXYPlot.setRenderer(1, line_XYLineAndShapeRenderer);

            XYDataset a_yequalsxXYLineChartXYDataset = ((XYPlot) t_yequalsxXYLineCharts[i].getPlot()).getDataset();
            XYLineAndShapeRenderer yequalsxline_XYLineAndShapeRenderer = new XYLineAndShapeRenderer(
                    true, false);
            a_ScatterPlotXYPlot.setDataset(2, a_yequalsxXYLineChartXYDataset);
            yequalsxline_XYLineAndShapeRenderer.setPaint(Color.green);
            a_ScatterPlotXYPlot.setRenderer(2, yequalsxline_XYLineAndShapeRenderer);
            result[i] = new JFreeChart(title, a_ScatterPlotXYPlot);
        }
        return result;
    }

    public static JFreeChart getYEqualsXLineChart(
            double[][] data,
            String xAxisLabel_String,
            String yAxisLabel_String) {
        JFreeChart a_XYLineChart = null;
        String title = null;
        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;
        double[][] lineChartData = new double[2][2];
        lineChartData[0][0] = Double.MAX_VALUE;// min_CASObservedData;
        lineChartData[0][1] = Double.MIN_VALUE;// max_CASObservedData;
        lineChartData[1][0] = Double.MAX_VALUE;// min_SARExpectedData;
        lineChartData[1][1] = Double.MIN_VALUE;// max_SARExpectedData;
        for (int j = 0; j < data[0].length; j++) {
            lineChartData[0][0] = Math.min(
                    lineChartData[0][0],
                    data[0][j]);
            lineChartData[0][1] = Math.max(
                    lineChartData[0][1],
                    data[0][j]);
            lineChartData[1][0] = Math.min(
                    lineChartData[1][0],
                    data[1][j]);
            lineChartData[1][1] = Math.max(
                    lineChartData[1][1],
                    data[1][j]);
        }
        lineChartData[1][0] = lineChartData[0][0];
        lineChartData[0][1] = Math.min(lineChartData[1][1], lineChartData[0][1]);
        lineChartData[1][1] = lineChartData[0][1];
        System.out.println("min lineChartData[0][0] "
                + lineChartData[0][0]);
        System.out.println("max lineChartData[0][1] "
                + lineChartData[0][1]);
        System.out.println("min lineChartData[1][0] "
                + lineChartData[1][0]);
        System.out.println("max lineChartData[1][1] "
                + lineChartData[1][1]);
        DefaultXYDataset a_DefaultXYDataset = new DefaultXYDataset();
        a_DefaultXYDataset.addSeries("y = x",
                lineChartData);
        a_XYLineChart =
                ChartFactory.createXYLineChart(
                title,
                xAxisLabel_String,
                yAxisLabel_String,
                a_DefaultXYDataset,
                PlotOrientation.HORIZONTAL,
                legend,
                tooltips,
                urls);
        return a_XYLineChart;
    }

    /**
     *
     * @param variablesNames_StringArray
     * @param aggregatedSARData
     * @param comparisonCASData
     * @return
     * @throws IOException
     */
    public static Object[] getRegressionParametersAndCreateXYLineCharts(
            String[] variablesNames_StringArray,
            double[][] aggregatedSARData,
            double[][] comparisonCASData)
            throws IOException {
        Object[] result = new Object[3];
        Object[] t_RegressionParameters = new Object[comparisonCASData.length];
        JFreeChart[] t_regressionXYLineCharts = new JFreeChart[comparisonCASData.length];
        JFreeChart[] t_yequalsxXYLineCharts = new JFreeChart[comparisonCASData.length];
        result[0] = t_RegressionParameters;
        result[1] = t_regressionXYLineCharts;
        result[2] = t_yequalsxXYLineCharts;
        String title = null;
//        String xAxisLabel;
//        String yAxisLabel;
//        xAxisLabel = new String("CAS Estimation (Observed)");
//        yAxisLabel = new String("SAR Prediction (Expected)");
        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;
        double[][] data;
        double[] a_RegressionParameters;
        for (int i = 0; i < comparisonCASData.length; i++) {
            title = variablesNames_StringArray[i + 1];
            double[][] bounds = new double[2][2];
            double[][] regressionLineChartData = new double[2][2];
            double[][] yequalsxLineChartData = new double[2][2];
            bounds[0][0] = Double.MAX_VALUE;// xmin SAR;
            bounds[0][1] = Double.MIN_VALUE;// xmax SAR;
            bounds[1][0] = Double.MAX_VALUE;// ymin CAS;
            bounds[1][1] = Double.MIN_VALUE;// ymax CAS;
            data = new double[2][comparisonCASData[i].length];
            for (int j = 0; j < comparisonCASData[i].length; j++) {
//                 data[0][j] = comparisonCASData[i][j];
//                 data[1][j] = aggregatedSARData[i][j];
                data[0][j] = aggregatedSARData[i][j];
                data[1][j] = comparisonCASData[i][j];
                bounds[0][0] =
                        Math.min(
                        bounds[0][0],
                        comparisonCASData[i][j]);
                bounds[0][1] =
                        Math.max(
                        bounds[0][1],
                        comparisonCASData[i][j]);
                bounds[1][0] =
                        Math.min(
                        bounds[1][0],
                        aggregatedSARData[i][j]);
                bounds[1][1] =
                        Math.max(
                        bounds[1][1],
                        aggregatedSARData[i][j]);
            }
            System.out.println("xmin SAR "
                    + bounds[0][0]);
            System.out.println("xmax SAR "
                    + bounds[0][1]);
            System.out.println("ymin CAS "
                    + bounds[1][0]);
            System.out.println("ymax CAS "
                    + bounds[1][1]);
            // intercept, slope, RSquare
            double[] aSimpleRegressionParameters = printSimpleRegression(data);
//            // intercept, slope, RSquare?
//            double[] aSimpleOLSParameters = printOLSRegression(data);
            double[] usedRegressionParameters = aSimpleRegressionParameters;
//            // Force origin to be (0,0)
//            yequalsxLineChartData[0][0] = 0.0d;
//            yequalsxLineChartData[1][0] = 0.0d;
            // Get intercept on x or y axis
            if (bounds[0][0] > bounds[1][0]) {
                yequalsxLineChartData[0][0] = bounds[0][0];
                yequalsxLineChartData[1][0] = bounds[0][0];
                if (usedRegressionParameters[0] < bounds[0][0]) {
                    regressionLineChartData[0][0] =
                            (bounds[0][0] * usedRegressionParameters[1])
                            + usedRegressionParameters[0];
                    regressionLineChartData[1][0] = 0.0d;
                } else {
                    regressionLineChartData[0][0] = 0.0d;
                    regressionLineChartData[1][0] = usedRegressionParameters[0];
                }
            } else {
                yequalsxLineChartData[0][0] = bounds[1][0];
                yequalsxLineChartData[1][0] = bounds[1][0];
                if (usedRegressionParameters[0] < bounds[1][0]) {
//                    regressionLineChartData[0][0] =
//                            (bounds[1][0] * usedRegressionParameters[1])
//                            + usedRegressionParameters[0];
                    regressionLineChartData[0][0] =
                            (bounds[1][0] - usedRegressionParameters[0])
                            / usedRegressionParameters[1];
                    regressionLineChartData[1][0] = 0.0d;
                } else {
                    regressionLineChartData[0][0] = 0.0d;
                    regressionLineChartData[1][0] = usedRegressionParameters[0];
                }
            }
            // Get intercept on edge of graph
            if (bounds[0][1] > bounds[1][1]) {
                yequalsxLineChartData[0][1] = bounds[1][1];
                yequalsxLineChartData[1][1] = bounds[1][1];
//                regressionLineChartData[0][1] =
//                        (yequalsxLineChartData[1][1] - usedRegressionParameters[0])
//                        / usedRegressionParameters[1];
                regressionLineChartData[1][1] =
                        (yequalsxLineChartData[1][1] * usedRegressionParameters[1])
                        + usedRegressionParameters[1];
//                regressionLineChartData[1][1] =
//                        (yequalsxLineChartData[0][1] - usedRegressionParameters[0])
//                        / usedRegressionParameters[1];
                regressionLineChartData[0][1] = yequalsxLineChartData[1][1];
                if (regressionLineChartData[1][1] > bounds[1][1] && regressionLineChartData[1][1] > bounds[0][1]) {
                    regressionLineChartData[1][1] = yequalsxLineChartData[0][1];
                    regressionLineChartData[0][1] =
                        (regressionLineChartData[1][1] - usedRegressionParameters[0])
                        / usedRegressionParameters[1];
                }
            } else {
                yequalsxLineChartData[0][1] = bounds[0][1];
                yequalsxLineChartData[1][1] = bounds[0][1];
                regressionLineChartData[0][1] =
                        (yequalsxLineChartData[0][1] - usedRegressionParameters[0])
                        / usedRegressionParameters[1];
                regressionLineChartData[1][1] = yequalsxLineChartData[0][1];
                if (regressionLineChartData[0][1] > bounds[0][1]) {
                    regressionLineChartData[1][1] = yequalsxLineChartData[0][1];
//                    regressionLineChartData[0][1] =
//                        (regressionLineChartData[1][1] * usedRegressionParameters[1])
//                        + usedRegressionParameters[1];
                    regressionLineChartData[0][1] =
                        (regressionLineChartData[1][1] - usedRegressionParameters[0])
                        / usedRegressionParameters[1];
                }
            }
            System.out.println("Regression line");
            t_RegressionParameters[i] = usedRegressionParameters;
            System.out.println("(minx,miny) (" + regressionLineChartData[0][0] + ","
                    + regressionLineChartData[1][0] + ")");
            System.out.println("(maxx,maxy) (" + regressionLineChartData[0][1] + ","
                    + regressionLineChartData[1][1] + ")");
            DefaultXYDataset regressionLineDefaultXYDataset = new DefaultXYDataset();
            regressionLineDefaultXYDataset.addSeries("Regression Line",
                    regressionLineChartData);
            t_regressionXYLineCharts[i] = ChartFactory.createXYLineChart(
                    title,
                    "",//xAxisLabel,
                    "",//yAxisLabel,
                    regressionLineDefaultXYDataset,
                    //PlotOrientation.HORIZONTAL,
                    PlotOrientation.VERTICAL,
                    legend, tooltips, urls);

            System.out.println("Y = X line");
            System.out.println("(minx,miny) (" + yequalsxLineChartData[0][0] + ","
                    + yequalsxLineChartData[1][0] + ")");
            System.out.println("(maxx,maxy) (" + yequalsxLineChartData[0][1] + ","
                    + yequalsxLineChartData[1][1] + ")");
            DefaultXYDataset yequalsxLineDefaultXYDataset = new DefaultXYDataset();
            yequalsxLineDefaultXYDataset.addSeries("y = x",
                    yequalsxLineChartData);
            t_yequalsxXYLineCharts[i] = ChartFactory.createXYLineChart(
                    title,
                    "",//xAxisLabel,
                    "",//yAxisLabel,
                    yequalsxLineDefaultXYDataset,
                    PlotOrientation.VERTICAL,
                    //PlotOrientation.HORIZONTAL,
                    legend, tooltips, urls);
        }
        return result;
    }

    public static JFreeChart[] createScatterPlots(
            String[] a_Variables,
            double[][] a_SARExpectedData,
            double[][] a_CASObservedData,
            String xAxisLabel,
            String yAxisLabel)
            throws IOException {
        JFreeChart[] result;
        String title = null;
        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;
        result = new JFreeChart[a_CASObservedData.length];
        double[][] data;
        double[] a_RegressionParameters;
        // double[][] data = new double[ _CASObservedData.length ][ 2 ];
        for (int i = 0; i < a_CASObservedData.length; i++) {
            title = a_Variables[i + 1];
            data = new double[2][a_CASObservedData[i].length];
            for (int j = 0; j < a_CASObservedData[i].length; j++) {
                data[0][j] = a_SARExpectedData[i][j];
                data[1][j] = a_CASObservedData[i][j];
            }
            DefaultXYDataset pointsDefaultXYDataset = new DefaultXYDataset();
            // pointsDefaultXYDataset.addSeries( "t_ScatterPlot" + i, data );
            pointsDefaultXYDataset.addSeries(a_Variables[i + 1], data);
            result[i] = ChartFactory.createScatterPlot(
                    title,
                    xAxisLabel,
                    yAxisLabel,
                    pointsDefaultXYDataset,
                    //PlotOrientation.HORIZONTAL,
                    PlotOrientation.VERTICAL,
                    legend,
                    tooltips,
                    urls);
        }
        return result;
    }

    public static BufferedImage[] outputImages(
            JFreeChart[] tJFreeCharts,
            int width,
            int height,
            String directory,
            String outputImageFileNamePrefix,
            String type)
            throws IOException {
        File directoryFile = new File(directory);
        if (!directoryFile.exists()) {
            directoryFile.mkdirs();
        }
        BufferedImage[] result = new BufferedImage[tJFreeCharts.length];
        for (int i = 0; i < tJFreeCharts.length; i++) {
            // System.out.println("i " + i);
            result[i] = tJFreeCharts[i].createBufferedImage(width, height);
            javax.imageio.ImageIO.write(result[i], type, new File(directory,
                    outputImageFileNamePrefix + i + "." + type));
        }
        return result;
    }

    public BufferedImage[] outputImages(
            JFreeChart[] tJFreeCharts,
            String[] _Variables,
            int width,
            int height,
            String _FilenamePrefix,
            File _OutputDirectory,
            String type)
            throws IOException {
        BufferedImage[] result = new BufferedImage[tJFreeCharts.length];
        for (int i = 0; i < tJFreeCharts.length; i++) {
            result[i] = tJFreeCharts[i].createBufferedImage(width, height);
            javax.imageio.ImageIO.write(result[i], type, new File(
                    _OutputDirectory, _FilenamePrefix + _Variables[i + 1] + "."
                    + type));
        }
        return result;
    }

    protected static Object[] loadData(
            File _SARExpectedFile,
            File _CASObservedFile)
            throws IOException {
        Object[] result = new Object[3];
        BufferedReader _SARExpectedBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(_SARExpectedFile)));
        StreamTokenizer _SARExpectedStreamTokenizer = new StreamTokenizer(
                _SARExpectedBufferedReader);
        StaticIO.setStreamTokenizerSyntax3(_SARExpectedStreamTokenizer);
        int _SARExpectedTokenType = _SARExpectedStreamTokenizer.nextToken();
        BufferedReader _CASObservedBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(_CASObservedFile)));
        StreamTokenizer _CASObservedStreamTokenizer = new StreamTokenizer(
                _CASObservedBufferedReader);
        StaticIO.setStreamTokenizerSyntax3(_CASObservedStreamTokenizer);
        int _CASObservedTokenType = _CASObservedStreamTokenizer.nextToken();
        // Read Headers
        String a_SARExpectedLine = _SARExpectedStreamTokenizer.sval;
        String[] _SARExpectedVariables = a_SARExpectedLine.split(",");
        String a_CASObservedLine = _CASObservedStreamTokenizer.sval;
        String[] _CASObservedVariables = a_CASObservedLine.split(",");
        int _NumberNumericalVariables = 0;
        // Check variables names the same
        if (_SARExpectedVariables.length != _CASObservedVariables.length) {
            System.out.println("t_SARExpectedVariables.length != _CASObservedVariables.length");
        } else {
            _NumberNumericalVariables = _SARExpectedVariables.length - 1;
            for (int i = 0; i < _SARExpectedVariables.length; i++) {
                if (!_CASObservedVariables[i].equalsIgnoreCase(_SARExpectedVariables[i])) {
                    System.out.print(_CASObservedVariables[i] + " != "
                            + _SARExpectedVariables[i]);
                }
            }
        }
        result[0] = _SARExpectedVariables; // Variable Names
        // Read Data
        double[] a_SARExpectedRow = new double[_NumberNumericalVariables];
        Vector _SARExpectedRows = new Vector();
        double[] a_CASObservedRow = new double[_NumberNumericalVariables];
        Vector _CASObservedRows = new Vector();
        _SARExpectedTokenType = _SARExpectedStreamTokenizer.nextToken();
        _CASObservedTokenType = _CASObservedStreamTokenizer.nextToken();
        Vector _ZoneCodes = new Vector();
        int _NumberOfAreas = 0;
        while (_SARExpectedTokenType != StreamTokenizer.TT_EOF
                && _CASObservedTokenType != StreamTokenizer.TT_EOF) {
            if (_SARExpectedTokenType != _CASObservedTokenType) {
                System.out.println("t_SARExpectedTokenType != _CASObservedTokenType");
            } else {
                switch (_SARExpectedTokenType) {
                    case StreamTokenizer.TT_WORD:
                        _NumberOfAreas++;
                        a_SARExpectedRow = new double[_NumberNumericalVariables];
                        a_SARExpectedLine = _SARExpectedStreamTokenizer.sval;
                        _SARExpectedVariables = a_SARExpectedLine.split(",");
                        a_CASObservedLine = _CASObservedStreamTokenizer.sval;
                        a_CASObservedRow = new double[_NumberNumericalVariables];
                        _CASObservedVariables = a_CASObservedLine.split(",");
                        if (_SARExpectedVariables.length != _CASObservedVariables.length) {
                            System.out.println("t_SARExpectedVariables.length != _CASObservedVariables.length");
                        }
                        if (_NumberNumericalVariables != _SARExpectedVariables.length - 1) {
                            System.out.println("t_NumberNumericalVariables != _SARExpectedVariables.length - 1");
                        }
                        // if ( _CASObservedVariables[ 0 ].startsWith(
                        // _SARExpectedVariables[ 0 ] ) ) {
                        _ZoneCodes.add(_CASObservedVariables[0]);
                        for (int i = 0; i < _NumberNumericalVariables; i++) {
                            a_SARExpectedRow[i] = Double.valueOf(
                                    _SARExpectedVariables[i + 1]).doubleValue();
                            a_CASObservedRow[i] = Double.valueOf(
                                    _CASObservedVariables[i + 1]).doubleValue();
                            if (i == 1
                                    && (a_SARExpectedRow[i] != a_CASObservedRow[i])) {
                                System.out.println("Warning ! constraint that allHouseholds observed ( "
                                        + a_CASObservedRow[i]
                                        + ") = allHouseholds expected ( "
                                        + a_SARExpectedRow[i]
                                        + " ) not met for "
                                        + _CASObservedVariables[0]);
                            }
                        }
                        _SARExpectedRows.add(a_SARExpectedRow);
                        _CASObservedRows.add(a_CASObservedRow);
                    // } else {
                    // System.out.println( _CASObservedVariables[ 0 ] + " != " +
                    // _SARExpectedVariables[ 0 ] );
                    // }
                }
            }
            _SARExpectedTokenType = _SARExpectedStreamTokenizer.nextToken();
            _CASObservedTokenType = _CASObservedStreamTokenizer.nextToken();
        }
        if (_SARExpectedRows.size() != _CASObservedRows.size()) {
            System.out.println("t_SARExpectedRows.size() != _CASObservedRows.size()");
        }
        if (_NumberOfAreas != _SARExpectedRows.size()) {
            System.out.println("t_NumberOfAreas != _SARExpectedRows.size()");
        }
        // Format (Flip) data
        double[][] _SARExpectedData = new double[_NumberNumericalVariables][_NumberOfAreas];
        double[][] _CASObservedData = new double[_NumberNumericalVariables][_NumberOfAreas];
        for (int j = 0; j < _NumberOfAreas; j++) {
            a_SARExpectedRow = (double[]) _SARExpectedRows.elementAt(j);
            a_CASObservedRow = (double[]) _CASObservedRows.elementAt(j);
            for (int i = 0; i < _NumberNumericalVariables; i++) {
                _SARExpectedData[i][j] = a_SARExpectedRow[i];
                _CASObservedData[i][j] = a_CASObservedRow[i];
            }
        }
        result[1] = _SARExpectedData;
        result[2] = _CASObservedData;
        return result;
    }

    /**
     * data[0][] = observed  SAR
     * data[1][] = expected  CAS
     *
     * @param data
     * @return 
     */
    public static double[] printSimpleRegression(double[][] data) {
        double[] result = new double[3];
        // org.apache.commons.math.stat.regression.SimpleRegression;
        SimpleRegression aSimpleRegression = new SimpleRegression();
        System.out.println("data.length " + data[0].length);
        for (int i = 0; i < data[0].length; i++) {
            // aSimpleRegression.addData( data[1][i], data[0][i] );
            aSimpleRegression.addData(data[0][i], data[1][i]);
        }
        double _Intercept = aSimpleRegression.getIntercept();
        double _Slope = aSimpleRegression.getSlope();
        double _RSquare = aSimpleRegression.getRSquare();
        System.out.println(" y = " + _Slope + " * x + " + _Intercept);
        System.out.println(" RSquare " + _RSquare);
        result[0] = _Intercept;
        result[1] = _Slope;
        result[2] = _RSquare;
        return result;
    }

    /**
     * data[0][] = observed data[1][] = expected
     * @param data
     * @return 
     */
    public static double[] printOLSRegression(double[][] data) {
        double[][] flipData = new double[data[0].length][2];
        for (int j = 0; j < data[0].length; j++) {
            for (int k = 0; k < 2; k++) {
                // flipData[j][ 1 - k ] = data[ k ][ j ];
                flipData[j][k] = data[k][j];
            }
        }
        // double[] a_RegressionParameters = Regression.getOLSRegression( data
        // );
        double[] a_RegressionParameters = Regression.getOLSRegression(flipData);
        System.out.println("y = " + a_RegressionParameters[1] + " * x + "
                + a_RegressionParameters[0]);
        return a_RegressionParameters;
    }
}
