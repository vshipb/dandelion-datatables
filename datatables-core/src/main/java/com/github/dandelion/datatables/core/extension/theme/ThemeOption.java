package com.github.dandelion.datatables.core.extension.theme;

import com.github.dandelion.datatables.core.constants.CdnConstants;

public enum ThemeOption {

	BASE(CdnConstants.CDN_JQUERYUI_THEME_BASE_CSS),
	BLACKTIE(CdnConstants.CDN_JQUERYUI_THEME_BLACKTIE_CSS),
	BLITZER(CdnConstants.CDN_JQUERYUI_THEME_BLITZER_CSS),
	CUPERTINO(CdnConstants.CDN_JQUERYUI_THEME_CUPERTINO_CSS),
	DARKHIVE(CdnConstants.CDN_JQUERYUI_THEME_DARKHIVE_CSS),
	DOTLUV(CdnConstants.CDN_JQUERYUI_THEME_DOTLUV_CSS),
	EGGPLANT(CdnConstants.CDN_JQUERYUI_THEME_EGGPLANT_CSS),
	EXCITEBIKE(CdnConstants.CDN_JQUERYUI_THEME_EXCITEBIKE_CSS),
	FLICK(CdnConstants.CDN_JQUERYUI_THEME_FLICK_CSS),
	HOTSNEAKS(CdnConstants.CDN_JQUERYUI_THEME_HOTSNEAKS_CSS),
	HUMANITY(CdnConstants.CDN_JQUERYUI_THEME_HUMANITY_CSS),
	LEFROG(CdnConstants.CDN_JQUERYUI_THEME_LEFROG_CSS),
	MINTCHOC(CdnConstants.CDN_JQUERYUI_THEME_MINTCHOC_CSS),
	OVERCAST(CdnConstants.CDN_JQUERYUI_THEME_OVERCAST_CSS),
	PEPPERGRINDER(CdnConstants.CDN_JQUERYUI_THEME_PEPPERGRINDER_CSS),
	REDMOND(CdnConstants.CDN_JQUERYUI_THEME_REDMOND_CSS),
	SMOOTHNESS(CdnConstants.CDN_JQUERYUI_THEME_SMOOTHNESS_CSS),
	SOUTHSTREET(CdnConstants.CDN_JQUERYUI_THEME_SOUTHSTREET_CSS),
	START(CdnConstants.CDN_JQUERYUI_THEME_START_CSS),
	SUNNY(CdnConstants.CDN_JQUERYUI_THEME_SUNNY_CSS),
	SWANKYPURSE(CdnConstants.CDN_JQUERYUI_THEME_SWANKYPURSE_CSS),
	TRONTASTIC(CdnConstants.CDN_JQUERYUI_THEME_TRONTASTIC_CSS),
	UIDARKNESS(CdnConstants.CDN_JQUERYUI_THEME_UIDARKNESS_CSS),
	UILIGHTNESS(CdnConstants.CDN_JQUERYUI_THEME_UILIGHTNESS_CSS),
	VADER(CdnConstants.CDN_JQUERYUI_THEME_VADER_CSS);
	
	private String cssSource;

	private ThemeOption(String cssSource){
		this.cssSource = cssSource;
	}
	
	public String getCssSource() {
		return cssSource;
	}

	public void setCssSource(String cssSource) {
		this.cssSource = cssSource;
	}
}