package com.dpc.springmvc_test.testmvc.repo;

import java.util.List;

import com.dpc.springmvc_test.testmvc.domain.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public void register(Member member);
}
