package com.why.newsbeat.service.collect.api;

import com.why.base.cache.AppCache;
import com.why.base.executor.ThreadManager;
import com.why.newsbeat.service.NewsBeat;
import com.why.newsbeat.service.collect.event.CollectNewsEvent;
import com.why.newsbeat.service.collect.bean.Collect;
import com.why.newsbeat.dao.greendao.CollectDao;
import com.why.newsbeat.dao.manager.DBManager;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 */

public class CollectImpl implements CollectApi {

	@Override
	public void loadCollections(final int number, final int page) {

		ThreadManager
				.getInstance()
				.getDefaultPool()
				.excute(new Runnable() {
					@Override
					public void run() {

						//数据库查询，按时间降序排列
						List<Collect> collectList = DBManager
								.getDaoSession(AppCache.getContext())
								.getCollectDao()
								.queryBuilder()
								.where(CollectDao.Properties.Username.eq(NewsBeat.getUserName()))
								.orderDesc(CollectDao.Properties.Save_time)
								.limit(number)
								.offset(page * number)
								.build()
								.list();

						EventBus.getDefault().post(new CollectNewsEvent(collectList));


					}
				});

	}
}
