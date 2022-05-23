package shop;

import java.io.Serializable;
import java.util.ArrayList;

public class ShohinArrayBean implements Serializable {

	private ArrayList<ShohinBean> ShohinHistoryArray = new ArrayList<ShohinBean>();

	public ShohinArrayBean() {
	}

	public ArrayList<ShohinBean> getShohinHistoryArray() {
		return ShohinHistoryArray;
	}

	public void addShohinHistoryArray (ShohinBean shb) {
		ShohinHistoryArray.add(shb);
	}

}
