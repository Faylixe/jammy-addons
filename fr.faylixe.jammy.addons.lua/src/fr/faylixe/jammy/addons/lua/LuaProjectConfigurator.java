package fr.faylixe.jammy.addons.lua;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.koneki.ldt.core.LuaNature;

import fr.faylixe.jammy.core.addons.IProjectConfigurator;
import fr.faylixe.jammy.core.common.EclipseUtils;

/**
 * {@link IProjectConfigurator} implementation for Lua addons.
 * 
 * @author fv
 */
public final class LuaProjectConfigurator implements IProjectConfigurator {

	/** Path to use as source folder. **/
	private static final String SOURCE_PATH = "src";

	/** {@inheritDoc} **/
	@Override
	public void configure(final IProject project, final IProgressMonitor monitor) throws CoreException {
		final IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { LuaNature.ID });
		project.setDescription(description, monitor);
		EclipseUtils.getFolder(project, SOURCE_PATH, monitor);
	}

}
