package dreamstar.study.dddjdbc;

import dreamstar.study.dddjdbc.domain.Area;
import dreamstar.study.dddjdbc.repo.AreaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
class DddJdbcApplicationTests {

    @Autowired
    AreaRepository areaRepository;

    @Test
    void t() {
        Optional<Area> byId = areaRepository.findById(0L);
        byId.ifPresent(area -> areaRepository.save(area));
        areaRepository.findById(0L).ifPresent(area -> {
//            这个应该是对的
//            Assert.isTrue(3441 == area.noNullCount(), "error");
//            这个应该是错的
            Assert.isTrue(32 == area.noNullCount(), "error");
/*            try {
                System.out.println(new ObjectMapper().writeValueAsString(area));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }*/
        });
    }

}
