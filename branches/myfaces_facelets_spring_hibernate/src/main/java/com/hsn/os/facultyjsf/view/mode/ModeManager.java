package com.hsn.os.facultyjsf.view.mode;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("modeManager")
@Scope("session")
public class ModeManager implements Serializable {

	private PageMode mode = PageMode.NEW;
	
	public void setCurrentMode(PageMode mode) {
		this.mode = mode;
	}
	
	public void clearMode() {
		this.mode = PageMode.NEW;
	}
	                       
	public PageMode getCurrentMode() {
		return mode;
	}
	
	public boolean isNewMode() {
		return isModeMatches(PageMode.NEW);
	}

	public boolean isEditMode() {
		return isModeMatches(PageMode.EDIT);
	}
	
	public boolean isViewMode() {
		return isModeMatches(PageMode.VIEW);
	}
	
	private boolean isModeMatches(PageMode pageMode) {
		return mode.equals(pageMode);
	}
	
}
