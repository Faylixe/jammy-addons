package fr.faylixe.jammy.addons.python;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import fr.faylixe.jammy.core.common.EclipseUtils;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author fv
 */
public final class PythonAddonPlugin extends AbstractUIPlugin {

	/** Plugin identifier. **/
	public static final String PLUGIN_ID = "fr.faylixe.jammy.addons.python"; //$NON-NLS-1$

	/** Template to use for Java solver class file. **/
	private String template;

	/** Unique plugin instance. **/
	private static PythonAddonPlugin plugin;

	/**
	 * Getter for the solver template.
	 * 
	 * @return Solver template as {@link String}.
	 * @see #template
	 */
	public String getSolverTemplate() {
		return template;
	}

	/** {@inheritDoc} **/
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		template = EclipseUtils.getResource("/templates/solution.template.py", getBundle());
	}

	/** {@inheritDoc} **/
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static PythonAddonPlugin getDefault() {
		return plugin;
	}

}
