package com.ecn.urbapp.dialogs;

import java.util.ArrayList;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ecn.urbapp.R;
import com.ecn.urbapp.activities.MainActivity;
import com.ecn.urbapp.db.Composed;
import com.ecn.urbapp.db.Element;
import com.ecn.urbapp.db.ElementType;
import com.ecn.urbapp.db.GpsGeom;
import com.ecn.urbapp.db.Material;
import com.ecn.urbapp.db.Photo;
import com.ecn.urbapp.db.PixelGeom;
import com.ecn.urbapp.db.Project;

/**
 * This class creates the dialog that ask the user to choose the characteristics of the
 * zone
 * 
 * @author Jules Party
 * 
 */
public class ConfirmPhotoDialogFragment extends DialogFragment {

	//TODO Adddescription for javadoc
	private Dialog box;
	//TODO Adddescription for javadoc
	private Button bpok;
	//TODO Adddescription for javadoc
	private Button quit;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		box = new Dialog(getActivity());
		box.setContentView(R.layout.layout_confirm_dialog);
		box.setTitle(R.string.confirm_photo);
		box.setCanceledOnTouchOutside(true);
		bpok = (Button)box.findViewById(R.id.confirm_ok);
		bpok.setOnClickListener(listener_ok);
		quit = (Button)box.findViewById(R.id.confirm_quit);
		quit.setOnClickListener(listener_quit);
		return box;
	}

	//TODO Adddescription for javadoc
	private OnClickListener listener_ok = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			MainActivity.zones=null;
			
			MainActivity.composed= new ArrayList<Composed>();
			MainActivity.element= new ArrayList<Element>();
			MainActivity.elementType= new ArrayList<ElementType>();
			MainActivity.gpsGeom= new ArrayList<GpsGeom>();
			MainActivity.material= new ArrayList<Material>();
			MainActivity.pixelGeom= new ArrayList<PixelGeom>();
			MainActivity.project= new ArrayList<Project>();
			MainActivity.photo= new Photo();
			MainActivity.project = new ArrayList<Project>();
			
		
			box.dismiss();
		}
	};

	//TODO Adddescription for javadoc
	private OnClickListener listener_quit = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			MainActivity.pathImage=null;
			box.dismiss();
		}
	};
	/**
	 * Action realized when the user cancel the dialog (touch outside the dialog
	 * or press the back button)
	 */
	@Override
	public void onCancel(DialogInterface dialog) {
	}
}