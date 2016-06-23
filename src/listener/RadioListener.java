package listener;

import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import mygui.DrawShape;

public class RadioListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		ItemSelectable itemSelectable = e.getItemSelectable();
		if (itemSelectable.equals(DrawShape.rdoL))
			DrawShape.type = DrawShape.LINE;
		else if (itemSelectable.equals(DrawShape.rdoR))
			DrawShape.type = DrawShape.RECT;
		else if (itemSelectable.equals(DrawShape.rdoC))
			DrawShape.type = DrawShape.CIRCLE;
		else if (itemSelectable.equals(DrawShape.rdoO))
			DrawShape.type = DrawShape.OTHER;

	}

}
