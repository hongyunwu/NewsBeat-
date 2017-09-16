package com.why.newsbeat.ui.yule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.why.newsbeat.GlideApp;
import com.why.newsbeat.R;
import com.why.newsbeat.service.yule.bean.YuLeBean;

import java.util.List;

/**
 * Created by lenovo on 2017/9/3.
 */
public class YuLeViewAdapter extends RecyclerView.Adapter<YuLeItemViewHolder> {


	public static final int ITEM_TYPE_THUMB1 = 1;
	public static final int ITEM_TYPE_THUMB3 = 2;

	private List<YuLeBean.ResultBean.DataBean> mData;
	private Context mContext;

	public YuLeViewAdapter(Context context, List<YuLeBean.ResultBean.DataBean> data) {
		this.mContext = context;
		this.mData = data;
	}
	public void setData(@NonNull List<YuLeBean.ResultBean.DataBean> data) {
		this.mData = data;

	}

	public void addData(@NonNull List<YuLeBean.ResultBean.DataBean> data){
		if (mData==null){
			mData = data;
		}else {
			mData.addAll(data);
		}
	}
	@Override
	public int getItemViewType(int position) {
		YuLeBean.ResultBean.DataBean dataBean = mData.get(position);
		if (TextUtils.isEmpty(dataBean.getThumbnail_pic_s02())
				|| TextUtils.isEmpty(dataBean.getThumbnail_pic_s03())) {
			return ITEM_TYPE_THUMB1;
		}
		return ITEM_TYPE_THUMB3;
	}

	@Override
	public YuLeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		int layoutId = 0;
		if (viewType == ITEM_TYPE_THUMB1) {
			layoutId = R.layout.item_top_news1;
		} else if (viewType == ITEM_TYPE_THUMB3) {
			layoutId = R.layout.item_top_news3;
		}
		final YuLeItemViewHolder yuLeItemViewHolder = new YuLeItemViewHolder(LayoutInflater.from(mContext).inflate(layoutId, parent, false));
		yuLeItemViewHolder.setListeners(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = yuLeItemViewHolder.getAdapterPosition();
				switch (v.getId()){
					case R.id.item_top_news:
						if (onItemClickListener!=null){
							onItemClickListener.onItemClick(position,mData.get(position));
						}
						break;
					case R.id.delete:
						mData.remove(position);
						notifyItemRemoved(position);
						break;
				}

			}
		},yuLeItemViewHolder.item_top_news,yuLeItemViewHolder.delete);

		return yuLeItemViewHolder;
	}

	@Override
	public void onBindViewHolder(YuLeItemViewHolder holder, int position) {
		YuLeBean.ResultBean.DataBean dataBean = mData.get(position);

		holder.title.setText(dataBean.getTitle());
		holder.author.setText(dataBean.getAuthor_name());
		if (getItemViewType(position)==ITEM_TYPE_THUMB3){
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s()).into(holder.thumb_01);
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s02()).into(holder.thumb_02);
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s03()).into(holder.thumb_03);
		}else {
			GlideApp.with(mContext).load(dataBean.getThumbnail_pic_s()).into(holder.thumb_01);
		}

	}

	@Override
	public int getItemCount() {
		if (mData != null) {
			return mData.size();
		}
		return 0;
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	private OnItemClickListener onItemClickListener;
	public interface OnItemClickListener{

		void onItemClick(int position, YuLeBean.ResultBean.DataBean dataBean);
	}
}
