package fr.faylixe.jammy.addons.lua;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.koneki.ldt.debug.core.internal.LuaDebugConstants;

import fr.faylixe.jammy.core.ProblemSolver;
import fr.faylixe.jammy.core.addons.AbstractLaunchSolverRunner;
import fr.faylixe.jammy.core.addons.ISolverRunner;

/**
 * {@link ISolverRunner} implementation for Lua addon.
 * 
 * @author fv
 */
@SuppressWarnings("restriction")
public final class LuaSolverRunner extends AbstractLaunchSolverRunner {

	/**
	 * Default constructor.
	 * 
	 * @param solver Solver which aims to be ran.
	 * @param monitor Monitor instance used for Java execution.
	 */
	public LuaSolverRunner(ProblemSolver solver, IProgressMonitor monitor) {
		super(solver, monitor);
	}

	/** {@inheritDoc} **/
	@Override
	protected String getLaunchConfigurationType() {
		return LuaDebugConstants.ATTACH_LAUNCH_CONFIGURATION_ID;
	}

	/** {@inheritDoc} **/
	@Override
	protected Map<String, String> createAttributesMap(final String arguments, final String output) {
		final Map<String, String> attributes = createBaseMap(output);
		// TODO : Fill map using debug constant.
		return attributes;
	}

}
