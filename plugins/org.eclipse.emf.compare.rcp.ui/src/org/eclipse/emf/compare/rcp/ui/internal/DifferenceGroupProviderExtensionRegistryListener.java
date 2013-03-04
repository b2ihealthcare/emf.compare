/*******************************************************************************
 * Copyright (c) 2012, 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;

public class DifferenceGroupProviderExtensionRegistryListener extends AbstractRegistryEventListener {

	static final String TAG_GROUP_PROVIDER = "group"; //$NON-NLS-1$

	static final String ATT_CLASS = "class"; //$NON-NLS-1$

	static final String ATT_LABEL = "label"; //$NON-NLS-1$

	static final String ATT_ACTIVE = "activeByDefault"; //$NON-NLS-1$

	private final IDifferenceGroupProvider.Registry groupProviderRegistry;

	/**
	 * @param pluginID
	 * @param extensionPointID
	 * @param registry
	 */
	public DifferenceGroupProviderExtensionRegistryListener(String pluginID, String extensionPointID,
			ILog log, IDifferenceGroupProvider.Registry groupProviderRegistry) {
		super(pluginID, extensionPointID, log);
		this.groupProviderRegistry = groupProviderRegistry;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#validateExtensionElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean validateExtensionElement(IConfigurationElement element) {
		final boolean valid;

		if (element.getName().equals(TAG_GROUP_PROVIDER)) {
			if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
				valid = false;
			} else if (element.getAttribute(ATT_LABEL) == null) {
				logMissingAttribute(element, ATT_LABEL);
				valid = false;
			} else if (element.getAttribute(ATT_ACTIVE) == null) {
				logMissingAttribute(element, ATT_ACTIVE);
				valid = false;
			} else {
				valid = true;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#addedValid(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean addedValid(IConfigurationElement element) {
		try {
			IDifferenceGroupProvider provider = (IDifferenceGroupProvider)element
					.createExecutableExtension(ATT_CLASS);
			provider.setLabel(element.getAttribute(ATT_LABEL));
			if (Boolean.valueOf(element.getAttribute(ATT_ACTIVE)).booleanValue()) {
				provider.setDefaultSelected(true);
			} else {
				provider.setDefaultSelected(false);
			}
			IDifferenceGroupProvider previous = groupProviderRegistry.add(provider);
			if (previous != null) {
				log(IStatus.WARNING, element, "The group provider '" + provider.getClass().getName()
						+ "' is registered twice.");
			}
		} catch (CoreException e) {
			log(element, e);
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#removedValid(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean removedValid(IConfigurationElement element) {
		groupProviderRegistry.remove(element.getAttribute(ATT_CLASS));
		return true;
	}
}
