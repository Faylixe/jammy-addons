package fr.faylixe.jammy.addons.python;

import fr.faylixe.jammy.core.addons.ISolverTemplateFactory;

/**
 * {@link ISolverTemplateFactory} implementation
 * for Python addon.
 * 
 * @author fv
 */
public final class PythonSolverTemplateFactory implements ISolverTemplateFactory {

	/** {@inheritDoc} **/
	@Override
	public String getTemplate(final String name) {
		return PythonAddonPlugin.getDefault().getSolverTemplate();
	}

}
