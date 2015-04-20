package explorer;

import java.io.File;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class FicherosListModel implements ListModel<File> {

	private File _dir;
	private File[] _files;
	
	public FicherosListModel(File f) {
		_dir = f;
		_files = f.listFiles();
		if( _files == null ){
			_files = new File[0];
		}
	}

	@Override
	public int getSize() {
		return _files.length;
	}

	@Override
	public File getElementAt(int index) {
		return _files[index];
	}

	@Override
	public void addListDataListener(ListDataListener l) {
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
	}

}
