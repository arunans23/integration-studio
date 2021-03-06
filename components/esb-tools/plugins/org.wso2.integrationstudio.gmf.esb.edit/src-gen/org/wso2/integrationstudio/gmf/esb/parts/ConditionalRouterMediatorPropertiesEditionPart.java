/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface ConditionalRouterMediatorPropertiesEditionPart {

	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);


	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);


	/**
	 * @return the continueAfterRoute
	 * 
	 */
	public Boolean getContinueAfterRoute();

	/**
	 * Defines a new continueAfterRoute
	 * @param newValue the new continueAfterRoute to set
	 * 
	 */
	public void setContinueAfterRoute(Boolean newValue);




	/**
	 * Init the conditionalRouteBranches
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initConditionalRouteBranches(ReferencesTableSettings settings);

	/**
	 * Update the conditionalRouteBranches
	 * @param newValue the conditionalRouteBranches to update
	 * 
	 */
	public void updateConditionalRouteBranches();

	/**
	 * Adds the given filter to the conditionalRouteBranches edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToConditionalRouteBranches(ViewerFilter filter);

	/**
	 * Adds the given filter to the conditionalRouteBranches edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToConditionalRouteBranches(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the conditionalRouteBranches table
	 * 
	 */
	public boolean isContainedInConditionalRouteBranchesTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
