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

import java.util.HashMap;
import java.util.Random;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CAS001DataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CAS002DataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASKS002DataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASDataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASKS008DataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASKS020DataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASKS09bDataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASKS09cDataRecord;

//import uk.ac.leeds.ccg.andyt.projects.moses.extensions.AreaModelExtension;

/**
 * An abstract class to be extended by classes that evolve a better fitting
 * Individual and Household level data for the UK.
 */
public class GeneticAlgorithm {

	// /** Use _IndividualCensus._LogPrintWriter
	// * For logging
	// */
	// protected PrintWriter _LogPrintWriter;

	/**
	 * For holding a reference to the IndividualCensus class which instantiated
	 * this.
	 */
	protected IndividualCensus _IndividualCensus;

	/**
	 * Stores the initial population size for an optimisation
	 */
	public int _InitialPopulationSize;
	/**
	 * Stores the maximum number of solutions stored during an optimisation
	 */
	public int _MaxNumberOfSolutions;
	/**
	 * Stores the convergence threshold used during an optimisation
	 */
	public int _ConvergenceThreshold;
	/**
	 * Stores the maximum number of mutations or changes per child used during
	 * an optimisation
	 */
	public int _MaxNumberOfMutationsPerChild;
	/**
	 * Stores the maximum number of mutations or changes per parent used during
	 * an optimisation
	 */
	public int _MaxNumberOfMutationsPerParent;
	/**
	 * Stores the number of optimisation iterations of an optimisation
	 */
	public int _NumberOfOptimisationIterations;

	/**
	 * For holding a reference to a random number generator.
	 */
	protected Random _Random;

	/**
	 * For storing the seed for random number generation.
	 */
	protected long _RandomSeed;

	/**
	 * For holding fitness counts
	 */
	protected Object[] _FitnessCounts;

	/**
	 * For holding a reference to a CASDataRecord
	 */
	protected CASDataRecord _CASDataRecord;

	/**
	 * For holding a reference to a CASKS002DataRecord
	 */
	protected CASKS002DataRecord _CASKS002DataRecord;

	public GeneticAlgorithm() {
	}

	public GeneticAlgorithm(int _InitialPopulationSize,
			int _NumberOfOptimisationIterations, int _MaxNumberOfSolutions,
			int _ConvergenceThreshold, int _MaxNumberOfMutationsPerChild,
			int _MaxNumberOfMutationsPerParent, long _RandomSeed) {
		this._InitialPopulationSize = _InitialPopulationSize;
		this._NumberOfOptimisationIterations = _NumberOfOptimisationIterations;
		this._MaxNumberOfSolutions = _MaxNumberOfSolutions;
		this._ConvergenceThreshold = _ConvergenceThreshold;
		this._MaxNumberOfMutationsPerChild = _MaxNumberOfMutationsPerChild;
		this._MaxNumberOfMutationsPerParent = _MaxNumberOfMutationsPerParent;
		this._RandomSeed = _RandomSeed;
		this._Random = new Random(_RandomSeed);
	}

    

	// /**
	// * @return A BigDecimal indicating how well _Population fits
	// _CASDataRecord.
	// * <ol>
	// * <li>This is a sum of the sum of squared difference between
	// _CASDataRecord values and estimated aggregate measures.</li>
	// * <li>The lower the number returned the better the fit.</li>
	// * </ol>
	// * @param _Population
	// * <ul>
	// * <li>_Population[0] is a Vector _HP.</li>
	// * <li>_Population[1] is an ISARDataRecord[] for building
	// * communal establishments _Populations</li>
	// * </ul>
	// */
	// public abstract Object getFitness( Object[] _Population );

	// /**
	// * @return Object[] this._FitnessCounts:
	// * <ul>
	// * <li>this._FitnessCounts[0] is a HashMap where:
	// * <ul>
	// * <li>keys are Strings are names derived from AbstractCASDataRecord
	// fields</li>
	// * <li>values are counts derived from AbstractCASDataRecord values</li>
	// * </ul></li>
	// * <li>this.tFitnessCounts[1] is a HashMap where:
	// * <ul>
	// * <li>keys are Strings as in this.tFitnessCounts[0]</li>
	// * <li>values are all 0</li>
	// * </ul></li>
	// * </ul></li>
	// */
	// public abstract Object[] getFitnessCounts();
	// {
	// if ( this._FitnessCounts == null ) {
	// this._FitnessCounts = new Object[ 2 ];
	// // Initialise Count HashMaps to compare
	// HashMap tCASCounts = new HashMap();
	// HashMap _SARCounts = new HashMap();
	// // Initialise age gender variables from CAS001DataRecord and
	// CAS002DataRecord
	// CAS001DataRecord aCAS001DataRecord =
	// this._CASDataRecord.getCAS001DataRecord();
	// CAS002DataRecord aCAS002DataRecord =
	// this._CASDataRecord.getCAS002DataRecord();
	// CASKS008DataRecord aCASKS008DataRecord =
	// this._CASDataRecord.getCASKS008DataRecord();
	// CASKS020DataRecord aCASKS020DataRecord =
	// this._CASDataRecord.getCASKS020DataRecord();
	// CASKS09bDataRecord aCASKS09bDataRecord =
	// this._CASDataRecord.getCASKS09bDataRecord();
	// CASKS09cDataRecord aCASKS09cDataRecord =
	// this._CASDataRecord.getCASKS09cDataRecord();
	// // CAS001DataRecord
	// // males
	// String s_malesAge0to4 = new String( "malesAge0to4" );
	// String s_malesAge5to9 = new String( "malesAge5to9" );
	// String s_malesAge10to14 = new String( "malesAge10to14" );
	// String s_malesAge15to19 = new String( "malesAge15to19" );
	// String s_malesAge20to24 = new String( "malesAge20to24" );
	// String s_malesAge25to29 = new String( "malesAge25to29" );
	// String s_malesAge30to34 = new String( "malesAge30to34" );
	// String s_malesAge35to39 = new String( "malesAge35to39" );
	// String s_malesAge40to44 = new String( "malesAge40to44" );
	// String s_malesAge45to49 = new String( "malesAge45to49" );
	// String s_malesAge50to54 = new String( "malesAge50to54" );
	// String s_malesAge55to59 = new String( "malesAge55to59" );
	// String s_malesAge60to64 = new String( "malesAge60to64" );
	// String s_malesAge65to69 = new String( "malesAge65to69" );
	// String s_malesAge70to74 = new String( "malesAge70to74" );
	// String s_malesAge75to79 = new String( "malesAge75to79" );
	// // String s_malesAge80to84 = new String( "malesAge80to84" );
	// // String s_malesAge85to89 = new String( "malesAge85to89" );
	// // String s_malesAge90AndOver = new String( "malesAge90AndOver" );
	// String s_malesAge80AndOver = new String( "malesAge80AndOver" );
	// tCASCounts.put( s_malesAge0to4,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge0to4() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge0to4() );
	// tCASCounts.put( s_malesAge5to9,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge5to9() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge5to9() );
	// tCASCounts.put( s_malesAge10to14,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge10to14() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge10to14() );
	// tCASCounts.put( s_malesAge15to19,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge15to19() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge15to19() );
	// tCASCounts.put( s_malesAge20to24,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge20to24() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge20to24() );
	// tCASCounts.put( s_malesAge25to29,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge25to29() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge25to29() );
	// tCASCounts.put( s_malesAge30to34,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge30to34() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge30to34() );
	// tCASCounts.put( s_malesAge35to39,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge35to39() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge35to39() );
	// tCASCounts.put( s_malesAge40to44,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge40to44() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge40to44() );
	// tCASCounts.put( s_malesAge45to49,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge45to49() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge45to49() );
	// tCASCounts.put( s_malesAge50to54,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge50to54() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge50to54() );
	// tCASCounts.put( s_malesAge55to59,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge55to59() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge55to59() );
	// tCASCounts.put( s_malesAge60to64,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge60to64() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge60to64() );
	// tCASCounts.put( s_malesAge65to69,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge65to69() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge65to69() );
	// tCASCounts.put( s_malesAge70to74,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge70to74() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge70to74() );
	// tCASCounts.put( s_malesAge75to79,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge75to79() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge75to79() );
	// // tCASCounts.put( s_malesAge80to84,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge80to84() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge80to84() );
	// // tCASCounts.put( s_malesAge85to89,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge85to89() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge85to89() );
	// // tCASCounts.put( s_malesAge90AndOver,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge90AndOver() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge90AndOver() );
	// tCASCounts.put( s_malesAge80AndOver,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge90AndOver() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge90AndOver() +
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge80to84() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge80to84() +
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge85to89() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge85to89() +
	// aCAS001DataRecord.getCommunalEstablishmentResidentsMalesAge90AndOver() +
	// aCAS001DataRecord.getHouseholdResidentsMalesAge90AndOver() );
	// _SARCounts.put( s_malesAge0to4, 0 );
	// _SARCounts.put( s_malesAge5to9, 0 );
	// _SARCounts.put( s_malesAge10to14, 0 );
	// _SARCounts.put( s_malesAge15to19, 0 );
	// _SARCounts.put( s_malesAge20to24, 0 );
	// _SARCounts.put( s_malesAge25to29, 0 );
	// _SARCounts.put( s_malesAge30to34, 0 );
	// _SARCounts.put( s_malesAge35to39, 0 );
	// _SARCounts.put( s_malesAge40to44, 0 );
	// _SARCounts.put( s_malesAge45to49, 0 );
	// _SARCounts.put( s_malesAge50to54, 0 );
	// _SARCounts.put( s_malesAge55to59, 0 );
	// _SARCounts.put( s_malesAge60to64, 0 );
	// _SARCounts.put( s_malesAge65to69, 0 );
	// _SARCounts.put( s_malesAge70to74, 0 );
	// _SARCounts.put( s_malesAge75to79, 0 );
	// // _SARCounts.put( s_malesAge80to84, 0 );
	// // _SARCounts.put( s_malesAge85to89, 0 );
	// // _SARCounts.put( s_malesAge90AndOver, 0 );
	// _SARCounts.put( s_malesAge80AndOver, 0 );
	// // females
	// String s_femalesAge0to4 = new String( "femalesAge0to4" );
	// String s_femalesAge5to9 = new String( "femalesAge5to9" );
	// String s_femalesAge10to14 = new String( "femalesAge10to14" );
	// String s_femalesAge15to19 = new String( "femalesAge15to19" );
	// String s_femalesAge20to24 = new String( "femalesAge20to24" );
	// String s_femalesAge25to29 = new String( "femalesAge25to29" );
	// String s_femalesAge30to34 = new String( "femalesAge30to34" );
	// String s_femalesAge35to39 = new String( "femalesAge35to39" );
	// String s_femalesAge40to44 = new String( "femalesAge40to44" );
	// String s_femalesAge45to49 = new String( "femalesAge45to49" );
	// String s_femalesAge50to54 = new String( "femalesAge50to54" );
	// String s_femalesAge55to59 = new String( "femalesAge55to59" );
	// String s_femalesAge60to64 = new String( "femalesAge60to64" );
	// String s_femalesAge65to69 = new String( "femalesAge65to69" );
	// String s_femalesAge70to74 = new String( "femalesAge70to74" );
	// String s_femalesAge75to79 = new String( "femalesAge75to79" );
	// // String s_femalesAge80to84 = new String( "femalesAge80to84" );
	// // String s_femalesAge85to89 = new String( "femalesAge85to89" );
	// // String s_femalesAge90AndOver = new String( "femalesAge90AndOver" );
	// String s_femalesAge80AndOver = new String( "femalesAge80AndOver" );
	// tCASCounts.put( s_femalesAge0to4,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge0to4() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge0to4() );
	// tCASCounts.put( s_femalesAge5to9,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge5to9() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge5to9() );
	// tCASCounts.put( s_femalesAge10to14,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge10to14() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge10to14() );
	// tCASCounts.put( s_femalesAge15to19,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge15to19() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge15to19() );
	// tCASCounts.put( s_femalesAge20to24,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge20to24() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge20to24() );
	// tCASCounts.put( s_femalesAge25to29,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge25to29() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge25to29() );
	// tCASCounts.put( s_femalesAge30to34,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge30to34() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge30to34() );
	// tCASCounts.put( s_femalesAge35to39,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge35to39() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge35to39() );
	// tCASCounts.put( s_femalesAge40to44,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge40to44() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge40to44() );
	// tCASCounts.put( s_femalesAge45to49,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge45to49() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge45to49() );
	// tCASCounts.put( s_femalesAge50to54,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge50to54() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge50to54() );
	// tCASCounts.put( s_femalesAge55to59,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge55to59() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge55to59() );
	// tCASCounts.put( s_femalesAge60to64,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge60to64() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge60to64() );
	// tCASCounts.put( s_femalesAge65to69,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge65to69() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge65to69() );
	// tCASCounts.put( s_femalesAge70to74,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge70to74() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge70to74() );
	// tCASCounts.put( s_femalesAge75to79,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge75to79() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge75to79() );
	// // tCASCounts.put( s_femalesAge80to84,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge80to84() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge80to84() );
	// // tCASCounts.put( s_femalesAge85to89,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge85to89() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge85to89() );
	// // tCASCounts.put( s_femalesAge90AndOver,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge90AndOver()
	// + aCAS001DataRecord.getHouseholdResidentsFemalesAge90AndOver() );
	// tCASCounts.put( s_femalesAge80AndOver,
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge80to84() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge80to84() +
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge85to89() +
	// aCAS001DataRecord.getHouseholdResidentsFemalesAge85to89() +
	// aCAS001DataRecord.getCommunalEstablishmentResidentsFemalesAge90AndOver()
	// + aCAS001DataRecord.getHouseholdResidentsFemalesAge90AndOver() );
	// _SARCounts.put( s_femalesAge0to4, 0 );
	// _SARCounts.put( s_femalesAge5to9, 0 );
	// _SARCounts.put( s_femalesAge10to14, 0 );
	// _SARCounts.put( s_femalesAge15to19, 0 );
	// _SARCounts.put( s_femalesAge20to24, 0 );
	// _SARCounts.put( s_femalesAge25to29, 0 );
	// _SARCounts.put( s_femalesAge30to34, 0 );
	// _SARCounts.put( s_femalesAge35to39, 0 );
	// _SARCounts.put( s_femalesAge40to44, 0 );
	// _SARCounts.put( s_femalesAge45to49, 0 );
	// _SARCounts.put( s_femalesAge50to54, 0 );
	// _SARCounts.put( s_femalesAge55to59, 0 );
	// _SARCounts.put( s_femalesAge60to64, 0 );
	// _SARCounts.put( s_femalesAge65to69, 0 );
	// _SARCounts.put( s_femalesAge70to74, 0 );
	// _SARCounts.put( s_femalesAge75to79, 0 );
	// // _SARCounts.put( s_femalesAge80to84, 0 );
	// // _SARCounts.put( s_femalesAge85to89, 0 );
	// // _SARCounts.put( s_femalesAge90AndOver, 0 );
	// _SARCounts.put( s_femalesAge80AndOver, 0 );
	// // CAS002DataRecord
	// // males
	// String s_malesMarriedAge0to15 = new String( "malesMarriedAge0to15" );
	// String s_malesMarriedAge16to19 = new String( "malesMarriedAge16to19" );
	// String s_malesMarriedAge20to24 = new String( "malesMarriedAge20to24" );
	// String s_malesMarriedAge25to29 = new String( "malesMarriedAge25to29" );
	// String s_malesMarriedAge30to34 = new String( "malesMarriedAge30to34" );
	// String s_malesMarriedAge35to39 = new String( "malesMarriedAge35to39" );
	// String s_malesMarriedAge40to44 = new String( "malesMarriedAge40to44" );
	// String s_malesMarriedAge45to49 = new String( "malesMarriedAge45to49" );
	// String s_malesMarriedAge50to54 = new String( "malesMarriedAge50to54" );
	// String s_malesMarriedAge55to59 = new String( "malesMarriedAge55to59" );
	// String s_malesMarriedAge60to64 = new String( "malesMarriedAge60to64" );
	// String s_malesMarriedAge65to74 = new String( "malesMarriedAge65to74" );
	// String s_malesMarriedAge75to79 = new String( "malesMarriedAge75to79" );
	// // String s_malesMarriedAge80to84 = new String( "malesMarriedAge80to84"
	// );
	// // String s_malesMarriedAge85to89 = new String( "malesMarriedAge85to89"
	// );
	// // String s_malesMarriedAge90AndOver = new String(
	// "malesMarriedAge90AndOver" );
	// String s_malesMarriedAge80AndOver = new String(
	// "malesMarriedAge80AndOver" );
	// tCASCounts.put( s_malesMarriedAge0to15,
	// aCAS002DataRecord.getMalesMarriedAge0to15() );
	// tCASCounts.put( s_malesMarriedAge16to19,
	// aCAS002DataRecord.getMalesMarriedAge16to19() );
	// tCASCounts.put( s_malesMarriedAge20to24,
	// aCAS002DataRecord.getMalesMarriedAge20to24() );
	// tCASCounts.put( s_malesMarriedAge25to29,
	// aCAS002DataRecord.getMalesMarriedAge25to29() );
	// tCASCounts.put( s_malesMarriedAge30to34,
	// aCAS002DataRecord.getMalesMarriedAge30to34() );
	// tCASCounts.put( s_malesMarriedAge35to39,
	// aCAS002DataRecord.getMalesMarriedAge35to39() );
	// tCASCounts.put( s_malesMarriedAge40to44,
	// aCAS002DataRecord.getMalesMarriedAge40to44() );
	// tCASCounts.put( s_malesMarriedAge45to49,
	// aCAS002DataRecord.getMalesMarriedAge45to49() );
	// tCASCounts.put( s_malesMarriedAge50to54,
	// aCAS002DataRecord.getMalesMarriedAge50to54() );
	// tCASCounts.put( s_malesMarriedAge55to59,
	// aCAS002DataRecord.getMalesMarriedAge55to59() );
	// tCASCounts.put( s_malesMarriedAge60to64,
	// aCAS002DataRecord.getMalesMarriedAge60to64() );
	// tCASCounts.put( s_malesMarriedAge65to74,
	// aCAS002DataRecord.getMalesMarriedAge65to74() );
	// tCASCounts.put( s_malesMarriedAge75to79,
	// aCAS002DataRecord.getMalesMarriedAge75to79() );
	// // tCASCounts.put( s_malesMarriedAge80to84,
	// aCAS002DataRecord.getMalesMarriedAge80to84() );
	// // tCASCounts.put( s_malesMarriedAge85to89,
	// aCAS002DataRecord.getMalesMarriedAge85to89() );
	// // tCASCounts.put( s_malesMarriedAge90AndOver,
	// aCAS002DataRecord.getMalesMarriedAge90AndOver() );
	// tCASCounts.put( s_malesMarriedAge80AndOver,
	// aCAS002DataRecord.getMalesMarriedAge80to84() +
	// aCAS002DataRecord.getMalesMarriedAge85to89() +
	// aCAS002DataRecord.getMalesMarriedAge90AndOver() );
	// _SARCounts.put( s_malesMarriedAge0to15, 0 );
	// _SARCounts.put( s_malesMarriedAge16to19, 0 );
	// _SARCounts.put( s_malesMarriedAge20to24, 0 );
	// _SARCounts.put( s_malesMarriedAge25to29, 0 );
	// _SARCounts.put( s_malesMarriedAge30to34, 0 );
	// _SARCounts.put( s_malesMarriedAge35to39, 0 );
	// _SARCounts.put( s_malesMarriedAge40to44, 0 );
	// _SARCounts.put( s_malesMarriedAge45to49, 0 );
	// _SARCounts.put( s_malesMarriedAge50to54, 0 );
	// _SARCounts.put( s_malesMarriedAge55to59, 0 );
	// _SARCounts.put( s_malesMarriedAge60to64, 0 );
	// _SARCounts.put( s_malesMarriedAge65to74, 0 );
	// _SARCounts.put( s_malesMarriedAge75to79, 0 );
	// // _SARCounts.put( s_malesMarriedAge80to84, 0 );
	// // _SARCounts.put( s_malesMarriedAge85to89, 0 );
	// // _SARCounts.put( s_malesMarriedAge90AndOver, 0 );
	// _SARCounts.put( s_malesMarriedAge80AndOver, 0 );
	// // females
	// String s_femalesMarriedAge0to15 = new String( "femalesMarriedAge0to15" );
	// String s_femalesMarriedAge16to19 = new String( "femalesMarriedAge16to19"
	// );
	// String s_femalesMarriedAge20to24 = new String( "femalesMarriedAge20to24"
	// );
	// String s_femalesMarriedAge25to29 = new String( "femalesMarriedAge25to29"
	// );
	// String s_femalesMarriedAge30to34 = new String( "femalesMarriedAge30to34"
	// );
	// String s_femalesMarriedAge35to39 = new String( "femalesMarriedAge35to39"
	// );
	// String s_femalesMarriedAge40to44 = new String( "femalesMarriedAge40to44"
	// );
	// String s_femalesMarriedAge45to49 = new String( "femalesMarriedAge45to49"
	// );
	// String s_femalesMarriedAge50to54 = new String( "femalesMarriedAge50to54"
	// );
	// String s_femalesMarriedAge55to59 = new String( "femalesMarriedAge55to59"
	// );
	// String s_femalesMarriedAge60to64 = new String( "femalesMarriedAge60to64"
	// );
	// String s_femalesMarriedAge65to74 = new String( "femalesMarriedAge65to74"
	// );
	// String s_femalesMarriedAge75to79 = new String( "femalesMarriedAge75to79"
	// );
	// // String s_femalesMarriedAge80to84 = new String(
	// "femalesMarriedAge80to84" );
	// // String s_femalesMarriedAge85to89 = new String(
	// "femalesMarriedAge85to89" );
	// // String s_femalesMarriedAge90AndOver = new String(
	// "femalesMarriedAge90AndOver" );
	// String s_femalesMarriedAge80AndOver = new String(
	// "femalesMarriedAge80AndOver" );
	// tCASCounts.put( s_femalesMarriedAge0to15,
	// aCAS002DataRecord.getFemalesMarriedAge0to15() );
	// tCASCounts.put( s_femalesMarriedAge16to19,
	// aCAS002DataRecord.getFemalesMarriedAge16to19() );
	// tCASCounts.put( s_femalesMarriedAge20to24,
	// aCAS002DataRecord.getFemalesMarriedAge20to24() );
	// tCASCounts.put( s_femalesMarriedAge25to29,
	// aCAS002DataRecord.getFemalesMarriedAge25to29() );
	// tCASCounts.put( s_femalesMarriedAge30to34,
	// aCAS002DataRecord.getFemalesMarriedAge30to34() );
	// tCASCounts.put( s_femalesMarriedAge35to39,
	// aCAS002DataRecord.getFemalesMarriedAge35to39() );
	// tCASCounts.put( s_femalesMarriedAge40to44,
	// aCAS002DataRecord.getFemalesMarriedAge40to44() );
	// tCASCounts.put( s_femalesMarriedAge45to49,
	// aCAS002DataRecord.getFemalesMarriedAge45to49() );
	// tCASCounts.put( s_femalesMarriedAge50to54,
	// aCAS002DataRecord.getFemalesMarriedAge50to54() );
	// tCASCounts.put( s_femalesMarriedAge55to59,
	// aCAS002DataRecord.getFemalesMarriedAge55to59() );
	// tCASCounts.put( s_femalesMarriedAge60to64,
	// aCAS002DataRecord.getFemalesMarriedAge60to64() );
	// tCASCounts.put( s_femalesMarriedAge65to74,
	// aCAS002DataRecord.getFemalesMarriedAge65to74() );
	// tCASCounts.put( s_femalesMarriedAge75to79,
	// aCAS002DataRecord.getFemalesMarriedAge75to79() );
	// // tCASCounts.put( s_femalesMarriedAge80to84,
	// aCAS002DataRecord.getFemalesMarriedAge80to84() );
	// // tCASCounts.put( s_femalesMarriedAge85to89,
	// aCAS002DataRecord.getFemalesMarriedAge85to89() );
	// // tCASCounts.put( s_femalesMarriedAge90AndOver,
	// aCAS002DataRecord.getFemalesMarriedAge90AndOver() );
	// tCASCounts.put( s_femalesMarriedAge80AndOver,
	// aCAS002DataRecord.getFemalesMarriedAge80to84() +
	// aCAS002DataRecord.getFemalesMarriedAge85to89() +
	// aCAS002DataRecord.getFemalesMarriedAge90AndOver() );
	// _SARCounts.put( s_femalesMarriedAge0to15, 0 );
	// _SARCounts.put( s_femalesMarriedAge16to19, 0 );
	// _SARCounts.put( s_femalesMarriedAge20to24, 0 );
	// _SARCounts.put( s_femalesMarriedAge25to29, 0 );
	// _SARCounts.put( s_femalesMarriedAge30to34, 0 );
	// _SARCounts.put( s_femalesMarriedAge35to39, 0 );
	// _SARCounts.put( s_femalesMarriedAge40to44, 0 );
	// _SARCounts.put( s_femalesMarriedAge45to49, 0 );
	// _SARCounts.put( s_femalesMarriedAge50to54, 0 );
	// _SARCounts.put( s_femalesMarriedAge55to59, 0 );
	// _SARCounts.put( s_femalesMarriedAge60to64, 0 );
	// _SARCounts.put( s_femalesMarriedAge65to74, 0 );
	// _SARCounts.put( s_femalesMarriedAge75to79, 0 );
	// // _SARCounts.put( s_femalesMarriedAge80to84, 0 );
	// // _SARCounts.put( s_femalesMarriedAge85to89, 0 );
	// // _SARCounts.put( s_femalesMarriedAge90AndOver, 0 );
	// _SARCounts.put( s_femalesMarriedAge80AndOver, 0 );
	// // Initialise health variables from CASKS008DataRecord
	// String s_peopleWhoseGeneralHealthWasGood = new String(
	// "peopleWhoseGeneralHealthWasGood" );
	// String s_peopleWhoseGeneralHealthWasFairlyGood = new String(
	// "peopleWhoseGeneralHealthWasFairlyGood" );
	// String s_peopleWhoseGeneralHealthWasNotGood = new String(
	// "peopleWhoseGeneralHealthWasNotGood" );
	// String s_peopleWithLimitingLongTermIllness = new String(
	// "peopleWithLimitingLongTermIllness" );
	// tCASCounts.put( s_peopleWhoseGeneralHealthWasGood,
	// aCASKS008DataRecord.getPeopleWhoseGeneralHealthWasGood() );
	// tCASCounts.put( s_peopleWhoseGeneralHealthWasFairlyGood,
	// aCASKS008DataRecord.getPeopleWhoseGeneralHealthWasFairlyGood() );
	// tCASCounts.put( s_peopleWhoseGeneralHealthWasNotGood,
	// aCASKS008DataRecord.getPeopleWhoseGeneralHealthWasNotGood() );
	// tCASCounts.put( s_peopleWithLimitingLongTermIllness,
	// aCASKS008DataRecord.getPeopleWithLimitingLongTermIllness() );
	// _SARCounts.put( s_peopleWhoseGeneralHealthWasGood, 0 );
	// _SARCounts.put( s_peopleWhoseGeneralHealthWasFairlyGood, 0 );
	// _SARCounts.put( s_peopleWhoseGeneralHealthWasNotGood, 0 );
	// _SARCounts.put( s_peopleWithLimitingLongTermIllness, 0 );
	// // Initialise Household Composition variables from CASKS020DataRecord
	// String s_oneFamilyAndNoChildren = new String( "oneFamilyAndNoChildren" );
	// String s_marriedOrCohabitingCoupleWithChildren = new String(
	// "marriedOrCohabitingCoupleWithChildren" );
	// String s_loneParentHouseholdsWithChildren = new String(
	// "loneParentHouseholdsWithChildren" );
	// tCASCounts.put( s_oneFamilyAndNoChildren,
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersAllPensioners()
	// +
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren()
	// +
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren()
	// );
	// tCASCounts.put( s_marriedOrCohabitingCoupleWithChildren,
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent()
	// +
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren()
	// +
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent()
	// +
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren()
	// );
	// tCASCounts.put( s_loneParentHouseholdsWithChildren,
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent()
	// +
	// aCASKS020DataRecord.getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren()
	// );
	// _SARCounts.put( s_oneFamilyAndNoChildren, 0 );
	// _SARCounts.put( s_marriedOrCohabitingCoupleWithChildren, 0 );
	// _SARCounts.put( s_loneParentHouseholdsWithChildren, 0 );
	// // Initialise Employment variables from CASKS09bDataRecord
	// String s_malesAge16to24Unemployed = new String(
	// "malesAge16to24Unemployed" );
	// String s_malesAge16to74 = new String( "malesAge16to74" );
	// String s_malesAge16to74EconomicallyActiveEmployedFullTime = new String(
	// "malesAge16to74EconomicallyActiveEmployedFullTime" );
	// String s_malesAge16to74EconomicallyActiveEmployedPartTime = new String(
	// "malesAge16to74EconomicallyActiveEmployedPartTime" );
	// String s_malesAge16to74EconomicallyActiveSelfEmployed = new String(
	// "malesAge16to74EconomicallyActiveSelfEmployed" );
	// String s_malesAge16to74EconomicallyActiveUnemployed = new String(
	// "malesAge16to74EconomicallyActiveUnemployed" );
	// String s_malesAge16to74EconomicallyInactiveRetired = new String(
	// "malesAge16to74EconomicallyInactiveRetired" );
	// String s_malesAge16to74EconomicallyInactivePermanentlySickOrDisabled =
	// new String( "malesAge16to74EconomicallyInactivePermanentlySickOrDisabled"
	// );
	// String s_malesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily = new
	// String( "malesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily" );
	// String s_malesAge16to74EconomicallyInactiveOther = new String(
	// "malesAge16to74EconomicallyInactiveOther" );
	// String s_malesAge50AndOverUnemployed = new String(
	// "malesAge50AndOverUnemployed" );
	// tCASCounts.put( s_malesAge16to24Unemployed,
	// aCASKS09bDataRecord.getMalesAged16to24Unemployed() );
	// tCASCounts.put( s_malesAge16to74,
	// aCASKS09bDataRecord.getMalesAged16to74() );
	// tCASCounts.put( s_malesAge16to74EconomicallyActiveEmployedFullTime,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyActiveEmployeesFullTime()
	// );
	// tCASCounts.put( s_malesAge16to74EconomicallyActiveEmployedPartTime,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyActiveEmployeesPartTime()
	// );
	// tCASCounts.put( s_malesAge16to74EconomicallyActiveSelfEmployed,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyActiveSelfEmployed() );
	// tCASCounts.put( s_malesAge16to74EconomicallyActiveUnemployed,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyActiveUnemployed() );
	// tCASCounts.put( s_malesAge16to74EconomicallyInactiveRetired,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyInactiveRetired() );
	// tCASCounts.put(
	// s_malesAge16to74EconomicallyInactivePermanentlySickOrDisabled,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyInactivePermanentlySickOrDisabled()
	// );
	// tCASCounts.put(
	// s_malesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily()
	// );
	// tCASCounts.put( s_malesAge16to74EconomicallyInactiveOther,
	// aCASKS09bDataRecord.getMalesAged16to74EconomicallyInactiveOther() );
	// tCASCounts.put( s_malesAge50AndOverUnemployed,
	// aCASKS09bDataRecord.getMalesAged50AndOverUnemployed() );
	// _SARCounts.put( s_malesAge16to24Unemployed, 0 );
	// _SARCounts.put( s_malesAge16to74, 0 );
	// _SARCounts.put( s_malesAge16to74EconomicallyActiveEmployedFullTime, 0 );
	// _SARCounts.put( s_malesAge16to74EconomicallyActiveEmployedPartTime, 0 );
	// _SARCounts.put( s_malesAge16to74EconomicallyActiveSelfEmployed, 0 );
	// _SARCounts.put( s_malesAge16to74EconomicallyActiveUnemployed, 0 );
	// _SARCounts.put( s_malesAge16to74EconomicallyInactiveRetired, 0 );
	// _SARCounts.put(
	// s_malesAge16to74EconomicallyInactivePermanentlySickOrDisabled, 0 );
	// _SARCounts.put(
	// s_malesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily, 0 );
	// _SARCounts.put( s_malesAge16to74EconomicallyInactiveOther, 0 );
	// _SARCounts.put( s_malesAge50AndOverUnemployed, 0 );
	// // Initialise Employment variables from CASKS099DataRecord
	// String s_femalesAge16to24Unemployed = new String(
	// "femalesAge16to24Unemployed" );
	// String s_femalesAge16to74 = new String( "femalesAge16to74" );
	// String s_femalesAge16to74EconomicallyActiveEmployedFullTime = new String(
	// "femalesAge16to74EconomicallyActiveEmployedFullTime" );
	// String s_femalesAge16to74EconomicallyActiveEmployedPartTime = new String(
	// "femalesAge16to74EconomicallyActiveEmployedPartTime" );
	// String s_femalesAge16to74EconomicallyActiveSelfEmployed = new String(
	// "femalesAge16to74EconomicallyActiveSelfEmployed" );
	// String s_femalesAge16to74EconomicallyActiveUnemployed = new String(
	// "femalesAge16to74EconomicallyActiveUnemployed" );
	// String s_femalesAge16to74EconomicallyInactiveRetired = new String(
	// "femalesAge16to74EconomicallyInactiveRetired" );
	// String s_femalesAge16to74EconomicallyInactivePermanentlySickOrDisabled =
	// new String(
	// "femalesAge16to74EconomicallyInactivePermanentlySickOrDisabled" );
	// String s_femalesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily =
	// new String(
	// "femalesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily" );
	// String s_femalesAge16to74EconomicallyInactiveOther = new String(
	// "femalesAge16to74EconomicallyInactiveOther" );
	// String s_femalesAge50AndOverUnemployed = new String(
	// "femalesAge50AndOverUnemployed" );
	// tCASCounts.put( s_femalesAge16to24Unemployed,
	// aCASKS09cDataRecord.getFemalesAged16to24Unemployed() );
	// tCASCounts.put( s_femalesAge16to74,
	// aCASKS09cDataRecord.getFemalesAged16to74() );
	// tCASCounts.put( s_femalesAge16to74EconomicallyActiveEmployedFullTime,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyActiveEmployeesFullTime()
	// );
	// tCASCounts.put( s_femalesAge16to74EconomicallyActiveEmployedPartTime,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyActiveEmployeesPartTime()
	// );
	// tCASCounts.put( s_femalesAge16to74EconomicallyActiveSelfEmployed,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyActiveSelfEmployed()
	// );
	// tCASCounts.put( s_femalesAge16to74EconomicallyActiveUnemployed,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyActiveUnemployed() );
	// tCASCounts.put( s_femalesAge16to74EconomicallyInactiveRetired,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyInactiveRetired() );
	// tCASCounts.put(
	// s_femalesAge16to74EconomicallyInactivePermanentlySickOrDisabled,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyInactivePermanentlySickOrDisabled()
	// );
	// tCASCounts.put(
	// s_femalesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily()
	// );
	// tCASCounts.put( s_femalesAge16to74EconomicallyInactiveOther,
	// aCASKS09cDataRecord.getFemalesAged16to74EconomicallyInactiveOther() );
	// tCASCounts.put( s_femalesAge50AndOverUnemployed,
	// aCASKS09cDataRecord.getFemalesAged50AndOverUnemployed() );
	// _SARCounts.put( s_femalesAge16to24Unemployed, 0 );
	// _SARCounts.put( s_femalesAge16to74, 0 );
	// _SARCounts.put( s_femalesAge16to74EconomicallyActiveEmployedFullTime, 0
	// );
	// _SARCounts.put( s_femalesAge16to74EconomicallyActiveEmployedPartTime, 0
	// );
	// _SARCounts.put( s_femalesAge16to74EconomicallyActiveSelfEmployed, 0 );
	// _SARCounts.put( s_femalesAge16to74EconomicallyActiveUnemployed, 0 );
	// _SARCounts.put( s_femalesAge16to74EconomicallyInactiveRetired, 0 );
	// _SARCounts.put(
	// s_femalesAge16to74EconomicallyInactivePermanentlySickOrDisabled, 0 );
	// _SARCounts.put(
	// s_femalesAge16to74EconomicallyInactiveLookingAfterHomeOrFamily, 0 );
	// _SARCounts.put( s_femalesAge16to74EconomicallyInactiveOther, 0 );
	// _SARCounts.put( s_femalesAge50AndOverUnemployed, 0 );
	// this._FitnessCounts[ 0 ] = tCASCounts;
	// this._FitnessCounts[ 1 ] = _SARCounts;
	// }
	// return this._FitnessCounts;
	// }

}
