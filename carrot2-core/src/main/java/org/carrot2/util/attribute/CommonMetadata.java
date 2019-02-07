
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2012, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.util.attribute;

/**
 * Common metadata items for {@link BindableMetadata} and {@link AttributeMetadata}.
 */
public class CommonMetadata
{
    protected String title;
    protected String label;
    protected String description;

    /**
     * A one sentence summary of the element. Could be presented as a header of the tool
     * tip of the corresponding UI component.
     */
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * A short label for the element which can be presented as the label of the
     * corresponding UI component.
     */
    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }
    
    /**
     * A longer, possibly multi sentence, description of the element. Could be presented
     * as a body of the tool tip of the corresponding UI component.
     */
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String plainTextDescription)
    {
        this.description = plainTextDescription;
    }
}
