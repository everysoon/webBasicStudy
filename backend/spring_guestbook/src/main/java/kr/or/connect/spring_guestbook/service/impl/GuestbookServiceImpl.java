package kr.or.connect.spring_guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.spring_guestbook.dao.GuestbookDao;
import kr.or.connect.spring_guestbook.dao.LogDao;
import kr.or.connect.spring_guestbook.dto.Guestbook;
import kr.or.connect.spring_guestbook.dto.Log;
import kr.or.connect.spring_guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	// AutoWired : Bean 자동으로 등록해주는 어노테이션
	@Autowired
	GuestbookDao guestbookDao;

	@Autowired
	LogDao logDao;

	@Override
	@Transactional
	// Transactional : 읽기만 하는 메서드한테 붙여주면 내부적으로 readOnly로 처리해줌
	public List<Guestbook> getGuestbooks(Integer start) {
		return guestbookDao.selectAll(start, GuestbookService.LIMIT);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteGuestbook(Long id, String ip) {
		Log log = new Log();
		log.setId(id);
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return guestbookDao.deleteById(id);

	}

	@Override
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);
		Log log = new Log();
		log.setId(id);
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		return  guestbook;
	}

	@Override
	public int getCount() {
	return guestbookDao.selectCount();
	}
}
