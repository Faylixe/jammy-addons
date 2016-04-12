package fr.faylixe.jammy.addons.python;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.dltk.launching.AbstractScriptLaunchConfigurationDelegate;
import org.eclipse.dltk.launching.InterpreterConfig;

/**
 * 
 * @author fv
 */
public final class PythonLaunchConfigurationDelegate extends AbstractScriptLaunchConfigurationDelegate {

	@Override
	protected InterpreterConfig createInterpreterConfig(
			ILaunchConfiguration configuration, ILaunch launch)
			throws CoreException {
		// TODO Auto-generated method stub
		return super.createInterpreterConfig(configuration, launch);
	}

	/** {@inheritDoc} **/
	@Override
	public String getLanguageId() {
		return null;
	}

}
