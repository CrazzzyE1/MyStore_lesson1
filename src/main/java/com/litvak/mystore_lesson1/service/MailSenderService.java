package com.litvak.mystore_lesson1.service;

import com.litvak.mystore_lesson1.domain.User;

public interface MailSenderService {
    void sendActivateCode(User user);
}
