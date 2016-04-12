package fr.faylixe.jammy.addons.python;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.IProjectFragment;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.launching.ScriptRuntime;
import org.eclipse.dltk.python.core.PythonNature;

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
		description.setNatureIds(new String[] { PythonNature.NATURE_ID });
		project.setDescription(description, monitor);
		final IFolder sourceFolder = EclipseUtils.getFolder(project, SOURCE_PATH, monitor);
		// TODO : Check if necessary ? 
		final IScriptProject scriptProject = DLTKCore.create(project);
		final IProjectFragment root = scriptProject.getProjectFragment(sourceFolder);
		final IBuildpathEntry sourceEntry = DLTKCore.newSourceEntry(root.getPath());
		final IBuildpathEntry interpreter = ScriptRuntime.getDefaultInterpreterContainerEntry();
		final IBuildpathEntry [] entries = new IBuildpathEntry [] {sourceEntry, interpreter};
		scriptProject.setRawBuildpath(entries, monitor);
	}

}
