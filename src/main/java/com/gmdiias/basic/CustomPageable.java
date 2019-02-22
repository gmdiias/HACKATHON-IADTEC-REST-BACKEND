package com.gmdiias.basic;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CustomPageable implements Pageable {
	
	private int pageNumber;
	private int pageSize;
	private long offset;

	private Sort sort;
	
	public CustomPageable() {
		sort = Sort.unsorted();
	}

	@Override
	public Pageable next() {
		return this;
	}

	@Override
	public Pageable previousOrFirst() {
		return this;
	}

	@Override
	public Pageable first() {
		return this;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public long getOffset() {
		return offset;
	}

	@Override
	public Sort getSort() {
		return sort;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}
	
}
