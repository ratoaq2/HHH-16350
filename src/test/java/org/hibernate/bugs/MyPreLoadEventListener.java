package org.hibernate.bugs;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.event.spi.PreLoadEventListener;

public class MyPreLoadEventListener implements PreLoadEventListener {

	@Override
	public void onPreLoad(PreLoadEvent event) {
		assertThat(event.getState()).isNotNull();
	}

}
