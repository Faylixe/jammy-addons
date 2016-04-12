package fr.faylixe.jammy.addons.python;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.python.pydev.plugin.nature.PythonNature;

import fr.faylixe.jammy.core.addons.IProjectConfigurator;
import fr.faylixe.jammy.core.common.EclipseUtils;

/**
 * {@link IProjectConfigurator} implementation for Python addon.
 * Adds Python nature to created project and creates source folder.
 * 
 * @author fv
 */
public final class PythonProjectConfigurator implements IProjectConfigurator {

	/** Path to use as source folder. **/
	private static final String SOURCE_PATH = "src";

	/** {@inheritDoc} **/
	@Override
	public void configure(final IProject project, final IProgressMonitor monitor) throws CoreException {
		final IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { PythonNature.PYTHON_NATURE_ID });
		project.setDescription(description, monitor);
		EclipseUtils.getFolder(project, SOURCE_PATH, monitor);
	}

}
