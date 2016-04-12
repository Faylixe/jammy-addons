package fr.faylixe.jammy.addons.python;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.dltk.launching.ScriptLaunchConfigurationConstants;
import org.eclipse.dltk.launching.process.ScriptRuntimeProcessFactory;
import org.eclipse.dltk.python.core.PythonNature;
import org.eclipse.dltk.python.launching.PythonLaunchConfigurationConstants;

import fr.faylixe.jammy.core.ProblemSolver;
import fr.faylixe.jammy.core.addons.AbstractLaunchSolverRunner;
import fr.faylixe.jammy.core.addons.ISolverRunner;

/**
 * {@link ISolverRunner} implementation for Python addon.
 * 
 * @author fv
 */
public final class PythonSolverRunner extends AbstractLaunchSolverRunner {

	/**
	 * Default constructor.
	 * 
	 * @param solver Solver which aims to be ran.
	 * @param monitor Monitor instance used for Java execution.
	 */
	public PythonSolverRunner(final ProblemSolver solver, final IProgressMonitor monitor) {
		super(solver, monitor);
	}

	/** {@inheritDoc} **/
	@Override
	protected String getLaunchConfigurationType() {
		return PythonLaunchConfigurationConstants.ID_PYTHON_SCRIPT;
	}

	/** {@inheritDoc} **/
	@Override
	protected Map<String, String> createAttributesMap(final String arguments, final String output) {
		final Map<String, String> attributes = createBaseMap(output);
		final ProblemSolver solver = getSolver();
		attributes.put(ScriptLaunchConfigurationConstants.ATTR_MAIN_SCRIPT_NAME, "src/" + solver.getFile().getName());
		attributes.put(ScriptLaunchConfigurationConstants.ATTR_SCRIPT_NATURE, PythonNature.NATURE_ID);
		attributes.put(ScriptLaunchConfigurationConstants.ATTR_PROJECT_NAME, solver.getProject().getName());
		attributes.put(ScriptLaunchConfigurationConstants.ATTR_SCRIPT_ARGUMENTS, arguments);
		attributes.put(DebugPlugin.ATTR_PROCESS_FACTORY_ID, ScriptRuntimeProcessFactory.PROCESS_FACTORY_ID);
//		attributes.put("org.eclipse.debug.core.MAPPED_RESOURCE_PATHS", "[/test_project/A.py]");
//		attributes.put("org.eclipse.debug.core.MAPPED_RESOURCE_TYPES", "[1]");
		return attributes;
	}

}
