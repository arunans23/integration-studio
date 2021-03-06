/**
 *
 * $Id$
 */
package org.wso2.integrationstudio.datamapper.validation;

import org.eclipse.emf.common.util.EList;

import org.wso2.integrationstudio.datamapper.DataMapperLink;
import org.wso2.integrationstudio.datamapper.Element;

/**
 * A sample validator interface for {@link org.wso2.integrationstudio.datamapper.InNode}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InNodeValidator {
	boolean validate();

	boolean validateIncomingLink(EList<DataMapperLink> value);
	boolean validateElementParent(Element value);
}
