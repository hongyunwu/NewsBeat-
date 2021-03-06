package com.why.newsbeat.ui.top;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.*;
import android.support.v7.widget.DividerItemDecoration;

import com.why.base.ui.BaseFragment;
import com.why.newsbeat.R;
import com.why.newsbeat.service.NewsBeat;
import com.why.newsbeat.service.top.bean.TopBean;
import com.why.newsbeat.service.top.event.TopNewsEvent;
import com.why.newsbeat.ui.detail.NewsDetailActivity;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lenovo on 2017/9/3.
 */
public class TopFragment extends BaseFragment<TopViewHolder> {

	private boolean isRefreshing;
	private TopViewAdapter topViewAdapter;

	@Override
	public int getLayoutID() {
		return R.layout.fragment_news;
	}

	@Override
	public void initData() {

		viewHolder.swipe_refresh.setColorSchemeResources(R.color.colorPrimary);
		viewHolder.recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
		viewHolder.recycler_view.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
		viewHolder.swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				if (!isRefreshing){
					isRefreshing = true;
					loadData();
				}
			}
		});
		loadData();
	}

	private void loadData() {
		isRefreshing = true;
		viewHolder.swipe_refresh.setRefreshing(true);
		NewsBeat.loadTopNews();
	}

	/**
	 * 当头条新闻加载完成时回调
	 *
	 * @param topNewsEvent
	 */
	@Subscribe
	public void onLoadTopNews(TopNewsEvent topNewsEvent){
		if (topNewsEvent.isAvailable()){

			if (topViewAdapter==null){
				topViewAdapter = new TopViewAdapter(getContext(), topNewsEvent.getEvent().getResult().getData());
				topViewAdapter.setOnItemClickListener(new TopViewAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(int position, TopBean.ResultBean.DataBean dataBean) {
						Bundle bundle = new Bundle();
						bundle.putParcelable("news",dataBean);
						gotoSubActivity(NewsDetailActivity.class,bundle,false);
					}
				});
				viewHolder.recycler_view.setAdapter(topViewAdapter);
			}else {

				if (isRefreshing){
					topViewAdapter.setData(topNewsEvent.getEvent().getResult().getData());
				}else {
					topViewAdapter.addData(topNewsEvent.getEvent().getResult().getData());
				}

				topViewAdapter.notifyDataSetChanged();
			}

		}else {

		}

		isRefreshing = false;
		viewHolder.swipe_refresh.setRefreshing(false);
	}
}
