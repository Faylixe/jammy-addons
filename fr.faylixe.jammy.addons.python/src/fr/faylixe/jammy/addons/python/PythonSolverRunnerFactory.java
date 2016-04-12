package fr.faylixe.jammy.addons.python;

import org.eclipse.core.runtime.IProgressMonitor;

import fr.faylixe.jammy.core.ProblemSolver;
import fr.faylixe.jammy.core.addons.ISolverRunner;
import fr.faylixe.jammy.core.addons.ISolverRunnerFactory;

/**
 * {@link ISolverRunnerFactory} implementation for Python addon.
 * 
 * @author fv
 */
public final class PythonSolverRunnerFactory implements ISolverRunnerFactory {

	/** {@inheritDoc} **/
	@Override
	public ISolverRunner create(final ProblemSolver solver, final IProgressMonitor monitor) {
		return new PythonSolverRunner(solver, monitor);
	}

}
