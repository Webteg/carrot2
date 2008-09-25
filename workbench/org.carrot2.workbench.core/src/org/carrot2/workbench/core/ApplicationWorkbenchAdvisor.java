package org.carrot2.workbench.core;

import org.carrot2.workbench.core.ui.perspectives.SearchPerspective;
import org.eclipse.ui.application.*;

/**
 * Advisor for initial settings and configuration.
 */
final class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor
{
    /*
     * 
     */
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
        IWorkbenchWindowConfigurer configurer)
    {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

    /*
     * 
     */
    public String getInitialWindowPerspectiveId()
    {
        return SearchPerspective.ID;
    }

    /*
     * Main preference page.
     */
    public String getMainPreferencePageId()
    {
        return "org.carrot2.workbench.core.preferences.WorkbenchPreferencePage";
    }
    
    /*
     * 
     */
    @Override
    public void initialize(IWorkbenchConfigurer configurer)
    {
        super.initialize(configurer);
        configurer.setSaveAndRestore(true);
    }
}
