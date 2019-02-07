
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2019, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.util.resource;

import java.io.IOException;
import java.io.InputStream;

import org.carrot2.util.StreamUtils;

/**
 * A resource relative to a class. This resource provider caches the content of returned
 * resources and closes the stream handle in {@link #open()}.
 */
public final class ClassResource implements IResource
{
    /**
     * Instantiated class.
     */
    private Class<?> clazz;

    private String classname;

    private String resource;

    public ClassResource(Class<?> clazz, String resource)
    {
        this.classname = clazz.getName();
        this.clazz = clazz;
        this.resource = resource;
    }

    /**
     * Override the default open-from-URL method so that we don't lock the source JAR.
     */
    @Override
    public InputStream open() throws IOException
    {
        if (clazz == null) {
            throw new IOException("Could not reinstantiate class: " + classname 
                + " from context class loader to "
                + " load resource: " + resource);
        }
        return StreamUtils.prefetch(clazz.getResourceAsStream(resource));
    }
}
