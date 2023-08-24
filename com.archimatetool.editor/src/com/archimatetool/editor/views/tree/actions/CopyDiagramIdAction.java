/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.views.tree.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.jface.viewers.IStructuredSelection;

import com.archimatetool.editor.utils.StringUtils;
import com.archimatetool.editor.views.tree.TreeModelViewer;
import com.archimatetool.editor.views.tree.commands.RenameCommandHandler;
import com.archimatetool.model.impl.ArchimateDiagramModel;

public class CopyDiagramIdAction extends ViewerAction {

	public CopyDiagramIdAction(TreeModelViewer selectionProvider) {
		super(selectionProvider);
		setText(Messages.CopyDiagramIdAction_0);
		setId("copyDiagramId");
	}

	@Override
	public void run() {
		IStructuredSelection selection = getSelection();
        if(selection == null || selection.isEmpty()) {
            return;
        }

        Object element = selection.getFirstElement();
        /*if(RenameCommandHandler.canRename(element)) {
            ((TreeModelViewer)getSelectionProvider()).editElement(element);
        }*/
        ArchimateDiagramModel diagramModel = (ArchimateDiagramModel) element;
        String id = diagramModel.getId();
        id = id.substring(3, id.length() - 3);        
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(id), null);        
	}
	
	

}
