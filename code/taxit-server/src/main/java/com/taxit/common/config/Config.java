package com.taxit.common.config;

import java.net.URL;

import org.apache.commons.configuration.XMLConfiguration;
import org.springframework.stereotype.Component;

import com.taxit.common.exception.TaxitConfigException;
import com.taxit.common.util.Constants;
import com.taxit.common.util.StreamUtil;


@Component
public class Config {
	private XMLConfiguration conf;

	/* General */
	private String baseDirectoryPath = "";
	private boolean systemInitServiceEnabled = false;
	private int pageSize = 10;
	
	/* Thumbnails */
	private String tinyImageDir = "";
	private String smallImageDir = "";
	private String mediumImageDir = "";
	private String largeImageDir = "";

	/* Data Augmentation */
	private String dataAugmentationServerUrl = "";
	private String dataAugmentationServicePath = "";
	private String dataAugmentationServiceConceptList = "";
	private String dataAugmentationServiceConceptDetail = "";

	/* Roles */
	private String roleUser = "";
	private String roleAdministrator = "";
	private String roleModerator = "";
	private String roleArtist = "";

	/* Search */
	private boolean searchIndexerEnabled = false;
	private String searchIndexerFolder = "";
	private int searchPageSize = 10;

	public Config() {
		try {
			URL resource = StreamUtil.getResource(Constants.CONFIG);
			this.conf = new XMLConfiguration(resource);

			/* General */
			this.systemInitServiceEnabled = conf.getBoolean("system.initservice[@enabled]");
			this.baseDirectoryPath = conf.getString("dirs.basedir");
			this.pageSize = conf.getInt("pagination.pagesize");
			
			/* Thumbnails */
			this.tinyImageDir = conf.getString("dirs.image.tiny");
			this.smallImageDir = conf.getString("dirs.image.small");
			this.mediumImageDir = conf.getString("dirs.image.medium");
			this.largeImageDir = conf.getString("dirs.image.large");
			
			/* Data Augmentation */
			this.dataAugmentationServerUrl = conf.getString("dataAugmentation.url");
			this.dataAugmentationServicePath = conf.getString("dataAugmentation.servicePath");
			this.dataAugmentationServiceConceptList = conf.getString("dataAugmentation.serviceConceptList");
			this.dataAugmentationServiceConceptDetail = conf.getString("dataAugmentation.serviceConceptDetail");

			/* Roles */
			this.roleUser = conf.getString("roles.user");
			this.roleAdministrator = conf.getString("roles.administrator");
			this.roleModerator = conf.getString("roles.moderator");
			this.roleArtist = conf.getString("roles.artist");
			
			/* Search */
			this.searchPageSize = conf.getInt("search.pagesize");
			this.searchIndexerEnabled = conf.getBoolean("search.indexer[@enabled]");
			this.searchIndexerFolder = conf.getString("search.indexer.folder");

		} catch (Throwable e) {
			throw new TaxitConfigException("Cannot read configuration file " + Constants.CONFIG, e);
		}
	}

	public String getTinyImageDir() {
		return baseDirectoryPath + tinyImageDir;
	}

	public String getSmallImageDir() {
		return baseDirectoryPath + smallImageDir;
	}

	public String getMediumImageDir() {
		return baseDirectoryPath + mediumImageDir;
	}

	public String getLargeImageDir() {
		return baseDirectoryPath + largeImageDir;
	}

	public int getPageSize() {
		return pageSize;
	}

	public boolean isSystemInitServiceEnabled() {
		return systemInitServiceEnabled;
	}

	public String getDataAugmentationServerUrl() {
		return dataAugmentationServerUrl;
	}

	public String getDataAugmentationServicePath() {
		return dataAugmentationServicePath;
	}

	public String getDataAugmentationServiceConceptList() {
		return dataAugmentationServiceConceptList;
	}

	public String getDataAugmentationServiceConceptDetail() {
		return dataAugmentationServiceConceptDetail;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public String getRoleAdministrator() {
		return roleAdministrator;
	}

	public String getRoleModerator() {
		return roleModerator;
	}

	public String getRoleArtist() {
		return roleArtist;
	}

	public boolean isSearchIndexerEnabled() {
		return searchIndexerEnabled;
	}

	public String getSearchIndexerFolder() {
		return baseDirectoryPath + searchIndexerFolder;
	}

	public int getSearchPageSize() {
		return searchPageSize;
	}
	

}
