/*
 * Bitronix Transaction Manager
 *
 * Copyright (c) 2010, Bitronix Software.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA 02110-1301 USA
 */

package bitronix.tm.resource.jms;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import junit.framework.TestCase;

public class MessageProducerWrapperTest extends TestCase {

    private final DualSessionWrapper dualSessionWrapper = mock(DualSessionWrapper.class);
    private final MessageProducer messageProducer= mock(MessageProducer.class);
    private final PoolingConnectionFactory poolingConnectionFactory = mock(PoolingConnectionFactory.class);
    private final MessageProducerWrapper messageProducerWrapper = new MessageProducerWrapper(messageProducer, dualSessionWrapper, poolingConnectionFactory);

    public void testMessageConsumerClosed() throws Exception {
        messageProducerWrapper.close();
        verify(messageProducer, times(1)).close();
    }

    public void testGetDestination () throws JMSException {
        messageProducerWrapper.getDestination();
        verify(messageProducer, times(1)).getDestination();
    }

    public void testGetTimeToLive() throws JMSException {
        messageProducerWrapper.getTimeToLive();
        verify(messageProducer, times(1)).getTimeToLive();
    }

    public void testGetPriority() throws JMSException{
        messageProducerWrapper.getPriority();
        verify(messageProducer, times(1)).getPriority();
    }

    public void testGetDeliveryMode() throws JMSException{
        messageProducerWrapper.getDeliveryMode();
        verify(messageProducer, times(1)).getDeliveryMode();
    }

    public void testGetDisableMessageTimestamp() throws JMSException{
        messageProducerWrapper.getDisableMessageTimestamp();
        verify(messageProducer, times(1)).getDisableMessageTimestamp();
    }

    public void testGetDisableMessageID() throws JMSException{
        messageProducerWrapper.getDisableMessageID();
        verify(messageProducer, times(1)).getDisableMessageID();
    }

}

