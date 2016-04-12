package fr.faylixe.jammy.addons.lua;

import fr.faylixe.jammy.core.addons.ISolverTemplateFactory;

/**
 * {@link ISolverTemplateFactory} implementation
 * for Lua addon.
 * 
 * @author fv
 */
public final class LuaSolverTemplateFactory implements ISolverTemplateFactory {

	/** {@inheritDoc} **/
	@Override
	public String getTemplate(final String name) {
		return LuaAddonPlugin.getDefault().getSolverTemplate();
	}

}
