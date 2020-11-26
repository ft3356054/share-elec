package com.sgcc.uap;

import com.alibaba.edas.configcenter.config.ConfigChangeListener;
import com.alibaba.edas.configcenter.config.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ApplicationListener;

/**
 * Created by yizhan on 2018/3/26.
 */

public class EDASConfigContextRefresher implements ApplicationListener<ApplicationReadyEvent> {

	private Logger logger = LoggerFactory.getLogger(EDASConfigContextRefresher.class);

	private final ContextRefresher contextRefresher;

	public EDASConfigContextRefresher(ContextRefresher contextRefresher) {
		this.contextRefresher = contextRefresher;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		this.registerDiamondListenersForApplications();
	}

	private void registerDiamondListenersForApplications() {
	
	}

	private void addListener(String dataId, String groupId) {
		ConfigService.addListener(dataId, groupId, new ConfigChangeListener() {
			public void receiveConfigInfo(String configInfo) {
				try {
					contextRefresher.refresh();
					logger.info("notify success,dataId={},groupId={}", dataId, groupId);
				} catch (Exception e) {
					logger.error("notify fail,dataId={},groupId={},e", dataId, groupId, e);
				}
			}
		});
	}
}