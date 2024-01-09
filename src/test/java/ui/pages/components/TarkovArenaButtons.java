package ui.pages.components;

import org.junit.jupiter.params.provider.Arguments;
import ui.domain.Language;

import java.util.List;
import java.util.stream.Stream;

public interface TarkovArenaButtons {
    static Stream<Arguments> tarkovArenaButtonsTest() {
        return Stream.of(
                Arguments.of(Language.RU, List.of("Новости", "Поддержка", "Мерч", "Киберспорт", "Рейтинг")),
                Arguments.of(Language.EN, List.of("News", "Support", "Merch", "Esports", "Rating")),
                Arguments.of(Language.DE, List.of("News", "Support", "Merch", "Esports", "Ratings")),
                Arguments.of(Language.CN, List.of("新闻", "支持", "周边", "电子竞技", "排位")),
                Arguments.of(Language.IT, List.of("Novità", "Supporto", "Merce", "Esports", "Valutazione")),
                Arguments.of(Language.PL, List.of("Aktualności", "Wsparcie", "Sklep", "Esport", "Ocena")),
                Arguments.of(Language.TR, List.of("Haberler", "Destek", "Merch", "Esporlar", "Değerlendirme")),
                Arguments.of(Language.CZ, List.of("Novinky", "Podpora", "Merch", "Esport", "Hodnocení")),
                Arguments.of(Language.ES, List.of("Noticias", "Soporte", "Merch", "Esports", "Clasificación"))
        );
    }
}