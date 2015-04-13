package explorer;

import java.io.File;
import java.util.Arrays;

import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class ArbolDirectorios extends JTree{
	
	
	private class DirectoriosTreeModel implements TreeModel{

		private final Object[] NO_CHILDS = new Object[0];
		private final Object _raiz = "Sistema de ficheros";
		private final FileSystemView _fs = FileSystemView.getFileSystemView();
		
		@Override
		public Object getRoot() {
			return _raiz;
		}
		
		private Object[] getChilds( Object parent ){
			Object[] ret = null;
			if( parent == _raiz ){
				ret = _fs.getRoots();
			}
			if( parent instanceof File ){
				File f = (File) parent;
				ret = f.listFiles();
			}
			if( ret == null ){
				ret = NO_CHILDS;
			}
			log( "getChilds(" + parent + "):" + ret );
			return ret;
		}

		private void log(String s) {
			System.out.println(s);
			
		}

		@Override
		public Object getChild(Object parent, int index) {
			return getChilds(parent)[index];
		}

		@Override
		public int getChildCount(Object parent) {
			return getChilds(parent).length;
		}

		@Override
		public boolean isLeaf(Object node) {
			if( node instanceof File ){
				return ((File)node).isFile();
			}
			return getChildCount(node) == 0;
		}

		@Override
		public void valueForPathChanged(TreePath path, Object newValue) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getIndexOfChild(Object parent, Object child) {
			return Arrays.asList( getChilds(parent) ).indexOf(child);
		}

		@Override
		public void addTreeModelListener(TreeModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTreeModelListener(TreeModelListener l) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public ArbolDirectorios(){
		setModel( new DirectoriosTreeModel() );
	}
}
