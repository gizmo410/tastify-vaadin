package be.coruscantit.tastify.infra.config;

import be.coruscantit.tastify.domain.review.ReviewAR;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.HybridJpaRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.repository.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @since 11/05/14
 */
@Configuration
@ComponentScan(basePackageClasses = ReviewAR.class)
public class DomainConfiguration {

    @Bean
    Repository<ReviewAR> reviewRepository(final EntityManagerProvider entityManagerProvider, final EventBus eventBus, final EventStore eventStore) {
        final HybridJpaRepository<ReviewAR> repository = new HybridJpaRepository<ReviewAR>(entityManagerProvider, ReviewAR.class);
        repository.setEventBus(eventBus);
        repository.setEventStore(eventStore);
        return repository;
    }

    @Bean
    AggregateAnnotationCommandHandler<ReviewAR> reviewCommandHandler(final Repository<ReviewAR> reviewRepository, final CommandBus commandBus) {
        final AggregateAnnotationCommandHandler<ReviewAR> handler = new AggregateAnnotationCommandHandler<ReviewAR>(ReviewAR.class, reviewRepository);

        for (String supportedCommand : handler.supportedCommands()) {
            commandBus.subscribe(supportedCommand, handler);
        }

        return handler;
    }

}
