package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import view.IView;

public interface ITronModel {
	public IGrid getGrid();
	public void buildGrid();
}
