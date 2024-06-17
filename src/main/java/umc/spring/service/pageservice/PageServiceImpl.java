package umc.spring.service.pageservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class PageServiceImpl implements PageService {

    @Override
    public Integer ChangePage(Integer page) {
        return page -= 1;
    }
}
