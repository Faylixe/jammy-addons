package fr.faylixe.jammy.addons.python;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.python.pydev.debug.core.Constants;

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
		return Constants.ID_PYTHON_REGULAR_LAUNCH_CONFIGURATION_TYPE;
	}

	/** {@inheritDoc} **/
	@Override
	protected Map<String, String> createAttributesMap(final String arguments, final String output) {
		final Map<String, String> attributes = createBaseMap(output);
		final ProblemSolver solver = getSolver();
		attributes.put(Constants.ATTR_PROGRAM_ARGUMENTS, arguments);
		attributes.put(Constants.ATTR_PROJECT, solver.getProject().getName());
		attributes.put(Constants.ATTR_LOCATION, solver.getFile().getRawLocation().toOSString());
		return attributes;
	}

}
