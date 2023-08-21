package Observer20.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Observer20.Model.ObserverLocalInfo;
import Observer20.repository.ObserverLocalInfoRepository;

@Service
public class ObserverLocalInfoService {
	private final ObserverLocalInfoRepository observerLocalInfoRepository;

    public ObserverLocalInfoService(ObserverLocalInfoRepository localInfoRepository) {
        this.observerLocalInfoRepository = localInfoRepository;
    }

    public ObserverLocalInfo saveLocalInfo(ObserverLocalInfo localInfo) {
        return observerLocalInfoRepository.save(localInfo);
    }

    public Optional<ObserverLocalInfo> getLocalInfoByObscode(String obscode) {
        return observerLocalInfoRepository.findByObserverUser_Obscode(obscode);
    }

}
